package exercise.controller;

import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
@RestController
public class WelcomeController {
    @Autowired
    Daytime daytime;

    @GetMapping("/welcome")
    public String index() {
        var now = daytime.getName();
        return "It is " + now + " now! Welcome to Spring!";
    }
}
// END
