package com.example.javasqlite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SpringBootApplication
public class JavaSqliteApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSqliteApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/db")
    public Map<String, Object> db() {
        return jdbcTemplate.queryForMap("select * from users where id = " + (System.currentTimeMillis() % 5 + 1));
    }
}
