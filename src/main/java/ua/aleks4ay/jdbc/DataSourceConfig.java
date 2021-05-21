package ua.aleks4ay.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:WEB-INF/jdbc/jdbc.properties")
@ComponentScan(basePackages = "ua.aleks4ay.jdbc")
public class DataSourceConfig {

    @Resource
    Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.userName"));
        dataSource.setPassword(getPassword());
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        return dataSource;
    }

    private String getPassword(){
        return Decryptor.decryptString(env.getRequiredProperty("jdbc.password"));
    }
}
