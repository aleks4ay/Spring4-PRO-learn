package ua.aleks4ay.jdbc;

import java.util.List;

interface ContactDao {
    List<Contact> findAll();
    void insert(Contact contact);
    void delete(Long contactId);
}
