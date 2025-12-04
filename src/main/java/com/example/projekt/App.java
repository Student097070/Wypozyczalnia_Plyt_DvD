package com.example.projekt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.ConnectDB;

import java.io.IOException;

public class App extends Application {

    private ConnectDB db = new ConnectDB();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(App.class.getResource("Menu.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Wypozyczalnia plyt DVD");
        stage.setScene(scene);
        stage.show();

        db.getConnection();
    }

    public static void main(String[] args) { launch(); }
}



