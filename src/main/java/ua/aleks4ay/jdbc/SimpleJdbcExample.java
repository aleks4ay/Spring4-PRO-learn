package ua.aleks4ay.jdbc;

import java.util.List;

public class SimpleJdbcExample {
    private static ContactDao dao = new SimpleContactDao();

    public static void main(String[] args) {
        List<Contact> contacts = dao.findAll();
        contacts.forEach(System.out::println);
    }
}
