package ua.aleks4ay.example_1;

import org.springframework.stereotype.Component;

@Component
public class MessageRenderer {
    private String mass = "Hello world";

    void render() {
        System.out.println(mass);
    }
}
