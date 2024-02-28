package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
@ComponentScan(basePackages = "org.example")
public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        AddToSQL addToSQL = context.getBean(AddToSQL.class);
        addToSQL.sendToService();
    }
}
