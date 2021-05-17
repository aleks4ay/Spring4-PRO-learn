package ua.aleks4ay.jdbc;

import java.util.List;

interface ContactDao {
    List<Contact> findAll();
    String selectFirstNameById(int id);
    void insert(Contact contact);
    void delete(Long contactId);
}
