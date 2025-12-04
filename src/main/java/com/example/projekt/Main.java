package com.example.projekt;
import models.ConnectDB;
import java.sql. *;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        //Application.launch(App.class, args);
        ConnectDB db = new ConnectDB();
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createTable="CREATE TABLE IF NOT EXISTS Filmy (id INTEGER PRIMARY KEY, name TEXT UNIQUE, wypozyczono BOOLEAN)";

                createTable= "CREATE TABLE IF NOT EXISTS Uzytkownicy (id INTEGER PRIMARY KEY, login TEXT UNIQUE, haslo TEXT )";
                statement.executeUpdate(createTable);

            } catch (SQLException e) {
                e.printStackTrace();
            }
//            finally {
//                db.closeConnection();
//            }
        } else {
            System.out.println("Connection failed");
        }
        Application.launch(App.class, args);
    }
}
