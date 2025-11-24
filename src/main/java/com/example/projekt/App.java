package com.example.projekt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.ConnectDB;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage){

        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/projekt/Menu.fxml")
            );
            Scene scene = new Scene(root);
            stage.setTitle("Wypozyczalnia plyt DVD");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
