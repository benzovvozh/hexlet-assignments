@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div>
        <ul>
            @for(var post: page.getPosts())
                <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
            @endfor
        </ul>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link"
                                     href="${NamedRoutes.postsPath() + "?page=" +(page.getPageNumber() -1)}"
                >Previous</a></li>
            <li class="page-item"><a class="page-link"
                                     href="${NamedRoutes.postsPath() + "?page=" + (page.getPageNumber()+1)}">Next</a>
            </li>
        </ul>
    </nav>
`
)
