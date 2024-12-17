package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = null;
        try {
            result = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Car deserialize(String carString){
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = null;
        try {
            car = objectMapper.readValue(carString, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
    // END
}
