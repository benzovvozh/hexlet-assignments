package exercise;

import java.util.HashMap;
import java.util.Map;


// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> map;

    public InMemoryKV(Map<String, String> inputMap) {
        this.map = new HashMap<>(inputMap);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        String getDefault = defaultValue;

        if (!map.containsKey(key)) {
            return getDefault;
        }

        return map.get(key);
    }

    @Override
    public Map<String, String> toMap() {

        return new HashMap<>(map);
    }
}
// END
