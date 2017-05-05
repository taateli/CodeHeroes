package app.config;

import java.net.URISyntaxException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Class for setting up the database connection
 *
 */
@Configuration
@Profile("production")
public class DatabaseConfig {

    /**
     * Method for handling database connection
     *
     * @return BasicDataSource object
     * @throws URISyntaxException if syntax wrong
     */
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

}
