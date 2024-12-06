package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String toString() {
        if (attributes.isEmpty()) {
            return "<" + tagName + ">";
        }

        return "<" + tagName + " " + getKeyValue(attributes) + ">";
    }


}
// END
