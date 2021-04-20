package ua.aleks4ay.example_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.aleks4ay.example_1.config.JavaConfig;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        MessageRenderer mr = appContext.getBean("messageRenderer", MessageRenderer.class);
        mr.render();
    }
}
