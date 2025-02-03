@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Пользователи</h1>
    <table>
        @for(var user: page.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td>
                    <a href="users/${user.getId()}">
                        ${user.getFirstName()}${user.getLastName()}
                    </a>
                    ${user.getEmail()}
                </td>
            </tr>
        @endfor
    </table>
`
)
