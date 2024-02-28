package org.example;
import org.springframework.stereotype.Service;
import java.sql.*;

@Service
public class AddToSQLService {
    private static final String DB_URL = "jdbc:sqlite:db.sqlite";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password TEXT)";

    public AddToSQLService(){
        try (Connection connection = DriverManager.getConnection(DB_URL)){
            connection.createStatement().executeUpdate(CREATE_TABLE_SQL);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void addToSQLService(String name, String pass) {
        try (Connection connection = DriverManager.getConnection(DB_URL)){
            String sql = "INSERT INTO users (name, password) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, pass);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Veri başarıyla eklendi.");
                } else {
                    System.out.println("Veri eklenirken bir hata oluştu.");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
