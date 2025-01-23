package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var number = ctx.pathParamAsClass("id", Integer.class).get();

            if (number < 0 || number >= COMPANIES.size()) {
                throw new NotFoundResponse("Company not found");
            }
            var result = new HashMap<>();

            for (var company : COMPANIES) {
                if (company.get("id").equals(number.toString())) {
                    result.putAll(company);
                }
            }
            ctx.json(result);


        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
