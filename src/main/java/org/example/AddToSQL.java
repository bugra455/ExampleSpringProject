package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class AddToSQL {

    private AddToSQLService addToSQLService;

    @Autowired
    public void userInput (AddToSQLService svc){
        this.addToSQLService = svc;
    }

    public void sendToService() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("üye adı girin:");
        String name = scanner.nextLine();
        System.out.println("Üyenin şifresini girin");
        String password = scanner.nextLine();
        addToSQLService.addToSQLService(name, password);
    }
}
