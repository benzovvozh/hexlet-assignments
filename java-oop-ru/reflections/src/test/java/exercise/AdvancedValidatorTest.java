package exercise;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class AdvancedValidatorTest {
    @Test
    void testAdvancedValidate() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        Map<String, List<String>> result1 = Validator.advancedValidate(address1);
        Map<String, List<String>> expected1 = new HashMap<>();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        Map<String, List<String>> result2 = Validator.advancedValidate(address2);
        Map<String, List<String>> expected2 = Map.of("country", List.of("cannot be null"));
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        Map<String, List<String>> result3 = Validator.advancedValidate(address3);
        Map<String, List<String>> expected3 = new HashMap<>();
        expected3.put("country", List.of("length less than 4"));
        expected3.put("city", List.of("cannot be null"));
        expected3.put("street", List.of("cannot be null"));
        expected3.put("houseNumber", List.of("cannot be null"));
        assertThat(result3).isEqualTo(expected3);
    }
}