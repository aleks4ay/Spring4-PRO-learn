package ua.aleks4ay.example_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationSpring {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        MessageRenderer mr = appContext.getBean("renderer", MessageRenderer.class);
        mr.print();
    }
}
