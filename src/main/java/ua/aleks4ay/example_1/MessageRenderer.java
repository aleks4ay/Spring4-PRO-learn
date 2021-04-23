package ua.aleks4ay.example_1;

public class MessageRenderer {
    private MessageProvider messageProvider;

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    void print() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class: "
                    + MessageRenderer.class.getName());
        }
        messageProvider.getMessage();
    }
}
