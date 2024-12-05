package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String someTag;
    private TagInterface someThing;

    public LabelTag(String someTag, TagInterface someThing) {
        this.someTag = someTag;
        this.someThing = someThing;


    }

    @Override
    public String render() {
        String rendered = someThing.render();

        return "<label>" + someTag + rendered + "</label>";
    }
}
// END
