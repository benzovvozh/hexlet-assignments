package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1); // получили страницу
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5); // получаем кол-во выводимых записей
            var offset = (page - 1) * per; // получаем смещение (с какого элемента начинать выборку) 0
            var list = USERS.subList(offset, offset + per); // создаем саблист, где начинаем выборку с offset до offset + per (от 0 до 5)
            ctx.json(list);


        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
