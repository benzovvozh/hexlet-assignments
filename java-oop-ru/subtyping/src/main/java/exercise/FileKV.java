package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private final Map<String, String> map;
    private final Map<String, String> readedMap;
    private String filepath;

    public FileKV(String filepath, Map<String, String> startedMap) {
        map = new HashMap<>(startedMap);
        this.filepath = filepath;
        String some = Utils.readFile(filepath); // получаем строковое содержимое файла
        readedMap = new HashMap<>(Utils.deserialize(some)); // десериализуем содержимое файла (получаем в виде мап)

    }

    @Override
    public void set(String key, String value) {

        map.put(key, value);
        readedMap.putAll(map);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
        readedMap.putAll(map);
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
