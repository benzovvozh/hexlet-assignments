@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Hexlet Javalin Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav>
        <div>
            <p><a href="/">Главная</a></p>
        </div>
    </nav>
</header>
<h1>Список пользователей</h1>
<div>
    <form action="/users" method="get">
        <input type="search" name = "term" value="${page.getTerm()}" />
        <input type="submit" value="Искать" />
    </form>
</div>
<div>
    <ul>
        @for(var user: page.getUsers())
            <li>${user.getId()} ${user.getFirstName()} ${user.getLastName()}</li>
        @endfor
    </ul>
</div>
<footer>
    <p><a href="https://github.com/benzovvozh/hexlet-assignments/tree/main/java-web-ru/template">link</a></p>
</footer>
</body>
</html>