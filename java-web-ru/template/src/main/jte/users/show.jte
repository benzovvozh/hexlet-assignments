@import exercise.dto.users.UserPage
@param UserPage page
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>User</title>
</head>
<body>

    <ul>
        <li>ID:  ${page.getUser().getId()}</li>
        <li>first name: ${page.getUser().getFirstName()}</li>
        <li>last name: ${page.getUser().getLastName()}</li>
        <li>email: ${page.getUser().getEmail()}</li>
    </ul>




</body>
</html>