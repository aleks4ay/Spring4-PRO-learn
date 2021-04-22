package ua.aleks4ay.example_2;

import org.springframework.context.ApplicationEvent;

class MessageEvent extends ApplicationEvent{
    private String msg;

    MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
        System.out.println("Source = " + source);
    }

    String getMessage() {
        return msg;
    }
}