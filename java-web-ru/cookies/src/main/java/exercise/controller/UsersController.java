package exercise.controller;

import exercise.dto.users.UsersPage;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    public static void main(Context ctx) {
        ctx.render("users/index.jte");
    }

    public static void users(Context ctx) {
        var users = UserRepository.getEntities();
        var page = new UsersPage(users);
        ctx.render("users/userList.jte", model("page", page));
    }

    // BEGIN
    public static void cookie(Context ctx) {
        var name = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        var user = new User(name, lastName, email, password, token);
        ctx.cookie("token", token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        var cookie = ctx.cookie("token");
        if (user.getToken().equals(cookie)) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else ctx.redirect(NamedRoutes.buildUserPath());
    }
    // END
}
