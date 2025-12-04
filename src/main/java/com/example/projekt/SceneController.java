package com.example.projekt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ConnectDB;

import java.io.IOException;

public class SceneController {
    private Scene scene;
    private Stage stage;
    private ConnectDB db = new ConnectDB();

    @FXML
    private TextField login;

    @FXML
    private TextField login2;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password2;

    @FXML
    public void SwichToMenu(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projekt/Menu.fxml")
        );

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void SwichToLogin(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projekt/EkranLogowania.fxml")
        );

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void SwichToMainMenu(javafx.event.ActionEvent event) throws IOException {
        if (login2.getText().isEmpty() || password2.getText().isEmpty()) {

            Parent root2 = FXMLLoader.load(
                    getClass().getResource("/com/example/projekt/BladLogowania.fxml")
            );

            Stage popup = new Stage();
            popup.setTitle("Błąd logowania");

            popup.initModality(Modality.APPLICATION_MODAL);

            popup.setScene(new Scene(root2));
            popup.show();

            return;
        }
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projekt/EkranPoZalogowaniu.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void SwichToMainMenu2(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projekt/EkranPoZalogowaniu.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void SwichToCreate(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projekt/EkranTworzeniaKonta.fxml")
        );

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void SwichToWypozycz(javafx.event.ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("/com/example/projekt/EkranWypozyczania.fxml")
        );
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void SaveNewUser(javafx.event.ActionEvent event)throws IOException{
        if (login.getText().isEmpty() || password.getText().isEmpty()) {
            Parent root2 = FXMLLoader.load(
                    getClass().getResource("/com/example/projekt/BladLogowania.fxml")
            );

            Stage popup = new Stage();
            popup.setTitle("Błąd logowania");

            popup.initModality(Modality.APPLICATION_MODAL);

            popup.setScene(new Scene(root2));
            popup.show();

            return;
        }
        else {
            db.insertNewUser(login.getText(), password.getText());
            Parent root = FXMLLoader.load(
                    getClass().getResource("/com/example/projekt/EkranLogowania.fxml")
            );

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void PopupReturn(javafx.event.ActionEvent event){
        Stage popup = (Stage)((Node) event.getSource()).getScene().getWindow();
        popup.close();
    }
}