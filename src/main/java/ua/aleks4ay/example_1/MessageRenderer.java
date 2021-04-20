package ua.aleks4ay.example_1;

import javax.annotation.Resource;

public class MessageRenderer {
    private MessageProvider messageProvider;

    @Resource(name = "messageProvider")
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    void print() {
        messageProvider.printName();
        messageProvider.printMessage();
    }
}
