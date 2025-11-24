package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private Connection connection;
    public ConnectDB() {
        String url = "jdbc:sqlite:BazaFilmow.db";//  database URL
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() {
        try {
            if (connection != null) {
                System.out.println("Closing connection");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}