package ua.aleks4ay.example_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:WEB-INF/spring/app-context.xml");
        ctx. refresh ();

        Flat flat = ctx.getBean("flat", Flat.class);
        flat.getAbiturients().forEach(System.out::println);
    }
}
