package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void root(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var hashPassword = encrypt(password);
        var user = UsersRepository.findByName(name)
                .orElseThrow(() -> new NotFoundResponse("Wrong username"));
        ctx.sessionAttribute("name", name);
        if (!(user.getPassword().equals(hashPassword)) || !(user.getName().equals(name))) {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        } else {
            ctx.redirect("/");
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }

    // END
}
