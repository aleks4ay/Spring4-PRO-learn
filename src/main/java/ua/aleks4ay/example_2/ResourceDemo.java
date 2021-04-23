package ua.aleks4ay.example_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import java.io.File;

public class ResourceDemo{

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        File file2 = new File("src/main/resources/test4.txt");
        file2.createNewFile();

        System.out.println(file.getPath());

        Resource res1 = ctx.getResource("file://" + file.getPath());
        displayInfo(res1);

        Resource res2 = ctx.getResource("classpath:/test4.txt");
        displayInfo(res2);

        Resource res3 = ctx.getResource("http://google.com");
        displayInfo(res3);
    }

    private static void displayInfo(Resource resource) throws Exception{
        System.out.println(resource.getClass());
        System.out.println(resource.getURI() + "\n");
    }
}