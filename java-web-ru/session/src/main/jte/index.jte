@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page

@template.layout.page(
content = @`
    <h1>hello</h1>
    @if(page.getName() != null)
        <p>your name: ${page.getName().toString()}</p>
        <form>
            <a href="${NamedRoutes.logoutPath()}">Выйти</a>
        </form>
    @else
        <div>
            <a href="${NamedRoutes.loginPath()}">Войти</a>
        </div>
    @endif
`
)