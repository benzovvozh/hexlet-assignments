package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (var method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                var type = method.getReturnType().getSimpleName();
                System.out.println("Method " + method.getName() + " returns a value of type " + type);
            }
        }
        // END
    }
}
