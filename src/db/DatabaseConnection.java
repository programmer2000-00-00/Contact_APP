package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_contact_db",
                    "java_contact_user", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
        }
   return connection;
    }

}
