package ua.aleks4ay.example_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationSpring {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/WEB-INF/spring/app-context.xml");
        MessageRenderer mr = appContext.getBean("renderer", MessageRenderer.class);
        mr.print();
    }
}
