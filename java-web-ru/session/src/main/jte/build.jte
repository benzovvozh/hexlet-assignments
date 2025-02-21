@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
    content = @`
    @if(page.getError() != null && page !=null)
        <div>
            <p>${page.getError()}</p>
        </div>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text" placeholder="name" name="name" />
        <input type="password" placeholder="password" name="password" />
        <input type="submit" />
    </form>
`
)