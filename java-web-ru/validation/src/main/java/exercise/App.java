package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;

import java.util.List;

import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            // Получаем значения из формы
            String title = ctx.formParam("title");
            String content = ctx.formParam("content");

            try {
                // Валидация title
                String validatedTitle = ctx.formParamAsClass("title", String.class)
                        .check(value -> value != null && value.length() > 2, "Название не должно быть короче двух символов")
                        .check(value -> !ArticleRepository.existsByTitle(value), "Статья с таким названием уже существует")
                        .get();

                // Валидация content
                String validatedContent = ctx.formParamAsClass("content", String.class)
                        .check(value -> value != null && value.length() > 10, "Статья должна быть не короче 10 символов")
                        .get();

                // Создание и сохранение статьи
                var article = new Article(validatedTitle, validatedContent);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                // Обработка ошибок валидации
                // Используем значения из формы для title и content
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.status(422).render("articles/build.jte", model("page", page));
            }
        });

        // END


        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
