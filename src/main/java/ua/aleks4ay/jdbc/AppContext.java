package ua.aleks4ay.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppContext {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ua.aleks4ay.jdbc");
        ContactDao dao = ctx.getBean("contactDaoImpl", ContactDao.class);
        System.out.println(dao.selectFirstNameById(1));
        List<Contact> contacts = dao.findAll();
        contacts.forEach(System.out::println);
    }
}
