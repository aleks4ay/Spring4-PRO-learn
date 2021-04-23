package ua.aleks4ay.example_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public MessageRenderer renderer(){
        MessageRenderer messageRenderer = new MessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }

    @Bean
    public MessageProvider messageProvider() {
        return new MessageProvider("Привет с большой земли из Java-конфига!");
    }
}
