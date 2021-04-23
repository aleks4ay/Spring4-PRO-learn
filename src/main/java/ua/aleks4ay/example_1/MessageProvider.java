package ua.aleks4ay.example_1;

public class MessageProvider {
    private String message = "Default message";

    public MessageProvider() {
    }

    public MessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    void getMessage() {
        System.out.println(message);
    }
}
