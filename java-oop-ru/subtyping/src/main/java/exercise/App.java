package exercise;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage list) {
        var keys = list.toMap().keySet();
        // key=value, key2=value2 -> keys = key, key2
        String default1 = "default";
        for (var key : keys) {
            // получаем значение по старому ключу, которое ставится новым ключом
            String newKey = list.get(key, default1);
            list.unset(key); // удаляем старый ключ
            list.set(newKey, key); // устанавливаем новый ключ, а старый ключ делаем значением

        }
    }
}
// END
