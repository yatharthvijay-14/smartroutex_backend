package com.yatharth.smart_road.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url:jdbc:h2:mem:smartroaddb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE}")
    private String dbUrl;

    @Value("${spring.datasource.username:sa}")
    private String username;

    @Value("${spring.datasource.password:}")
    private String password;

    @Bean
    @Primary
    public DataSource dataSource() {
        System.out.println("[SmartRouteX Database] Attempting connection to: " + dbUrl);

        if (dbUrl != null && dbUrl.startsWith("jdbc:mysql")) {
            try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
                System.out.println("[SmartRouteX Database] Successfully connected to MySQL database!");
                HikariDataSource ds = new HikariDataSource();
                ds.setJdbcUrl(dbUrl);
                ds.setUsername(username);
                ds.setPassword(password);
                ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
                return ds;
            } catch (Exception e) {
                System.err.println("[SmartRouteX Database] Warning: Could not connect to MySQL (" + e.getMessage() + "). Falling back to H2 In-Memory DB for cloud deployment!");
            }
        }

        // Default or Fallback: H2 In-Memory Database
        HikariDataSource h2Ds = new HikariDataSource();
        h2Ds.setJdbcUrl("jdbc:h2:mem:smartroaddb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        h2Ds.setUsername("sa");
        h2Ds.setPassword("");
        h2Ds.setDriverClassName("org.h2.Driver");
        return h2Ds;
    }
}
