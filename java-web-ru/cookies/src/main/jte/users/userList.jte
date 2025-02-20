@import exercise.dto.users.UsersPage
@import exercise.util.NamedRoutes
@param UsersPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Users</h1>


            <table class="table table-striped">
                @for(var user: page.getUsers())
                    <tr>
                        <td>
                            <a href="${NamedRoutes.userPath(user.getId())}">${user.getFirstName()}</a>
                        </td>
                        <td>
                            ${user.getLastName()}
                        </td>
                    </tr>
                @endfor
            </table>
        </main>
    </div>
`
)