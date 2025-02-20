@import exercise.dto.users.UserPage
@import exercise.util.NamedRoutes
@param UserPage page

@template.layout.page(
content = @`
<div>
    <ul>
        <li><a href="${NamedRoutes.userPath(page.getUser().getId())}">${page.getUser().getFirstName()}</a></li>
    </ul>
</div>
`)