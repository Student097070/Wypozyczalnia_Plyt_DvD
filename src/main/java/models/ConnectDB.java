package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectDB {
    private Connection connection;
    private Logger logger;
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

    public void closeConnection()throws SQLException {
        try {
            if (connection != null) {
                System.out.println("Closing connection");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertNewUser(String login, String password) {
        Connection conn = getConnection();

        String query = "INSERT INTO Uzytkownicy (login, password) VALUES (?, ?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
            logger.info("Uzytkownik inserted successfully");
        } catch (SQLException e) {
            logger.info("Błąd podczas dodawania użytkownika: " + e);
        }
    }
}