@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page, content = @`
    <ul>
        @if(page.getPosts() != null)
            <ul>
                @for(var post: page.getPosts())
                    <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
                @endfor
            </ul>
        @endif
    </ul>
`
)