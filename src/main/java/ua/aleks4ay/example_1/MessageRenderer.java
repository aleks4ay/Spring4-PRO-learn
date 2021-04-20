package ua.aleks4ay.example_1;

public class MessageRenderer {
    private MessageProvider messageProvider;

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    void print() {
        messageProvider.printName();
        messageProvider.printMessage();
    }
}
