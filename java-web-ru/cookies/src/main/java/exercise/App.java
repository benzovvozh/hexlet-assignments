package exercise;

import exercise.model.User;
import io.javalin.Javalin;
import exercise.controller.UsersController;
import exercise.util.NamedRoutes;
import io.javalin.rendering.template.JavalinJte;

import javax.naming.Name;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), UsersController::main);
        app.get(NamedRoutes.buildUserPath(),UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::cookie);
        app.get(NamedRoutes.usersPath(),UsersController::users);
        // END

        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
