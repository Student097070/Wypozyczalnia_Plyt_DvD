package com.example.projekt;
import java.sql. *;
import models.ConnectDB;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Application.launch(App.class, args);
        ConnectDB db = new ConnectDB();

        Connection connection = db.getConnection();


        if (connection != null) {

            try {

                Statement statement = connection.createStatement();

                String createTable="CREATE TABLE IF NOT EXISTS Filmy (id INTEGER PRIMARY KEY, name TEXT, wypozyczono BOOLEAN)";

                // Create table if not exists

//                Operation:C

                statement.executeUpdate(createTable);

                // Insert data
                //statement.executeUpdate("INSERT INTO Filmy (name) VALUES ('Diuna'), (wypozyczono) VALUES (False)");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                db.closeConnection();
            }
        } else {
            System.out.println("Connection failed");
        }
    }
}
