package ua.aleks4ay.example_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(value="classpath:META-INF/spring/app-context-xml.xml")
@PropertySource(value="classpath:message.properties", encoding = "UTF-8")
@ComponentScan(basePackages={"ua.aleks4ay.example_1"})
@EnableTransactionManagement
public class JavaConfig {

    private Environment env;

    @Bean
    @Scope(value="prototype")
    @DependsOn(value="messageProvider")
    public MessageRenderer renderer(){
        MessageRenderer messageRenderer = new MessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new MessageProvider(env.getProperty("mess"));
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
