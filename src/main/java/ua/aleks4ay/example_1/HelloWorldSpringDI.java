package ua.aleks4ay.example_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/WEB-INF/spring/app-context.xml");
        ctx. refresh ();
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.print();
    }
}
