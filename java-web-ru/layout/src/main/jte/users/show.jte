@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
<h1>Пользователь</h1>
    <ul>
        <li>${page.getUser().getLastName()}</li>
        <li>${page.getUser().getFirstName()}</li>
        <li>${page.getUser().getEmail()}</li>
    </ul>
`
)