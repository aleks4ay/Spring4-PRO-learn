package ua.aleks4ay.jdbc;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class AppContext {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:WEB-INF/jdbc/app-context.xml");
        ctx.refresh();
        ContactDao dao = ctx.getBean("contactDao", ContactDao.class);
        List<Contact> contacts = dao.findAll();
        contacts.forEach(System.out::println);
    }
}
