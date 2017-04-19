package in.cheoeum;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

    @Bean
    public JdbcHttpSessionConfiguration jdbcHttpSessionConfiguration() {
        return new JdbcHttpSessionConfiguration();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setUrl("jdbc:h2:./test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false");
        ds.setUser("sa");
        ds.setPassword("");
        return ds;
    }
}
