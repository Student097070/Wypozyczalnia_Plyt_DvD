package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectDB {
    private Connection connection;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void getConnection() {
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection("jdbc:sqlite:BazaFilmow.db");
                logger.info("Connection successful");
                //createTable();
            }
        }catch (SQLException e){
            logger.info(e.toString());
        }
    }

    private void createTable() {
        getConnection();
        String createTable="CREATE TABLE IF NOT EXISTS Filmy (id INTEGER PRIMARY KEY, name TEXT UNIQUE, wypozyczono BOOLEAN)";
        createTable= "CREATE TABLE IF NOT EXISTS Uzytkownicy (id INTEGER PRIMARY KEY, login TEXT UNIQUE, haslo TEXT )";
            try(PreparedStatement st = connection.prepareStatement(createTable)){
                st.executeUpdate(createTable);
                logger.info("Table created");
            }catch (SQLException e){
                logger.info(e.toString());
            }
    }

    private void closeConnection() throws SQLException {
        if (connection != null || !connection.isClosed()) {
            connection.close();
        }
    }

    public void insertNewUser(String login, String password) {
        getConnection();

        String query = "INSERT INTO Uzytkownicy (login, haslo) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
            logger.info("Uzytkownik inserted successfully");
        } catch (SQLException e) {
            logger.info(e.toString());
        }
    }
}