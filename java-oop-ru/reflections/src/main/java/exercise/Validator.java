package exercise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object obj) throws NoSuchFieldException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields(); //массив приватных полей
        // проходим по массиву
        for (var field : declaredFields) {
            if (field.getAnnotation(NotNull.class) != null) {
                field.setAccessible(true);
                // получаем имя поля
                String name = field.getName();
                // получаем значение поля
                var value = field.get(obj);
                // проверяем на null
                if (value == null) {
                    //добавляем в список
                    list.add(name);
                }
            }
        }
        return list;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        Map<String, List<String>> map = new HashMap<>();
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for (var field : declaredFields) {
            List<String> errorsList = new ArrayList<>();
            field.setAccessible(true);
            var name = field.getName();
            var value = field.get(obj);
            if (field.getAnnotation(NotNull.class) != null && value == null) {
                errorsList.add("cannot be null");
            }
            if (field.getAnnotation(MinLength.class) != null && value != null && value instanceof String) {
                // получаем значение из аннотации
                int minLength = field.getAnnotation(MinLength.class).value();
                if (((String) value).length() < minLength) {
                    errorsList.add("length less than " + minLength);
                }
            }
            if (!(errorsList.isEmpty())) {
                map.put(name, errorsList);
            }
        }
        return map;


    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Address address = new Address(null, "London", "1-st street", "7", null);
        List<String> notValidFields = Validator.validate(address);
        System.out.println(notValidFields); // => [country]

        Address address2 = new Address("England", null, null, "7", "2");
        List<String> notValidFields2 = Validator.validate(address2);
        System.out.println(notValidFields2); // => [city, street]
        Address address3 = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields3 = Validator.advancedValidate(address3);
        System.out.println(notValidFields3); // =>  {country=[length less than 4], street=[can not be null]}
    }
}
// END
