package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> childrenTags;

    public PairedTag(String tagName,
                     Map<String, String> attributes,
                     String tagBody,
                     List<Tag> childrenTags) {
        this.childrenTags = childrenTags;
        this.tagBody = tagBody;
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<" + tagName)
                .append(attributes.isEmpty() ? "" : " " + getKeyValue(attributes))
                .append(">")
                .append(tagBody);
        for (var item : childrenTags) {
            stringBuilder.append("<")
                    .append(item.getTagName())
                    .append(" " + getKeyValue(item.getAttributes()))
                    .append(">");
        }

        stringBuilder.append("</" + tagName + ">");
        return stringBuilder.toString();
    }
}
// END
