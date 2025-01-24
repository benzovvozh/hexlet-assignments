@import exercise.dto.users.UsersPage
@param UsersPage page
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getUserList().isEmpty())
    <p>Список пользователей пуст</p>
@else
    @for(var user: page.getUserList())
        <table>
            <tr>
                <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                <td><a href="/users/${user.getId()}">${user.getFirstName()}</a></td>
                <td><a href="/users/${user.getId()}">${user.getLastName()}</a></td>
                <td><a href="/users/${user.getId()}">${user.getEmail()}</a></td>
            </tr>
        </table>
    @endfor
@endif
</body>
</html>