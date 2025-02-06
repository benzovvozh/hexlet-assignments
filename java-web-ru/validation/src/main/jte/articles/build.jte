@import exercise.dto.articles.BuildArticlePage
@param  BuildArticlePage page


@template.layout.page(

content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
        <div>
            <label>
                <h1>Title</h1>
                <input name="title" type="text" value="${page.getTitle()}">
            </label>
        </div>
        <div>
            <label>
                <h1>Content</h1>
                <textarea name="content" >
                    ${page.getContent()}
                </textarea>
            </label>
        </div>
        <input type="submit" value="Опубликовать" />
    </form>
`
)