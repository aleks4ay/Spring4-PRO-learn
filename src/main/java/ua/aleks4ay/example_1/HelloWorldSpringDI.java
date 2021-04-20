package ua.aleks4ay.example_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctxParent = new GenericXmlApplicationContext();
        ctxParent.load("classpath:WEB-INF/spring/app-context.xml");
        ctxParent. refresh ();

        GenericXmlApplicationContext ctxChild = new GenericXmlApplicationContext();
        ctxChild.load("classpath:WEB-INF/spring/app-context-child.xml");
        ctxChild.setParent(ctxParent);
        ctxChild. refresh ();


        MessageRenderer mr = ctxChild.getBean("renderer", MessageRenderer.class);
        mr.print();
    }
}
