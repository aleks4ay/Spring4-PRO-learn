package ua.aleks4ay.example_1;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:WEB-INF/spring/app-context.xml");
        ctx. refresh ();

        ReplacementTarget standartTarget = ctx.getBean("targetStandart", ReplacementTarget.class);
        ReplacementTarget replacedTarget = ctx.getBean("targetReplaced", ReplacementTarget.class);
        displayInfo(standartTarget);
        displayInfo(replacedTarget);
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello!"));
        StopWatch stopWatch = new StopWatch("test 1");
        stopWatch.start();
        for (int i=0; i<1000000; i++) {
            String out = target.formatMessage("test");
        }
        stopWatch.stop();
        System.out.println("lOOOOOO invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
