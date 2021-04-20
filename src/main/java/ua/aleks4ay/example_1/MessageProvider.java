package ua.aleks4ay.example_1;

public class MessageProvider {
    private String name;
    private String message;

    public MessageProvider(String name, String message) {
        this.name = name;
        this.message = message;
    }

    void printName() {
        System.out.println(name);
    }

    void printMessage() {
        System.out.println(message);
    }
}
