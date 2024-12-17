package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        Files.write(path, car.serialize().getBytes(), StandardOpenOption.CREATE);
    }

    public static Car extract(Path path) throws IOException {
        String car = Files.readString(path);
        Car car1 = Car.deserialize(car);
        return car1;
    }
}
// END
