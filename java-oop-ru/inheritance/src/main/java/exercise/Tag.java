package exercise;


import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Map getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }

    protected String tagName;
    protected Map<String, String> attributes;

    public String getKeyValue(Map<String, String> attributes) {
        String result = attributes.entrySet()
                .stream()
                .map(entry ->
                        entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
        return result;
    }
}
// END
