package ua.aleks4ay.jdbc;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@DependsOn("dataSource")
public class ContactDaoImpl implements ContactDao, InitializingBean{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String selectFirstNameById(int id) {
        return jdbcTemplate.queryForObject("Select first_name from contact WHERE id=?;", new Object[]{id}, String.class);
    }

    @Override
    public void insert(Contact contact) {
        //NOP
    }

    @Override
    public void delete(Long contactId) {
        //NOP
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if (this.jdbcTemplate == null) {
            throw new BeanCreationException ("Null JdbcTemplate on ContactDao");
        }
    }

    @Override
    public List<Contact> findAll() {
        return jdbcTemplate.query("Select * from contact;", new ContactMapper());
    }

    private static final class ContactMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        }
    }
}