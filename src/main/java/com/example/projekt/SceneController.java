package Wypozyczalnia;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import  javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

//import java.awt.event.ActionEvent;
import java.io.IOException;

public class SceneController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    public void SwichToMenu(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/src/main/GUI/Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwichToLogin(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/src/main/GUI/EkranLogowania.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwichToWypozycz(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/src/main/GUI/EkranLogowania.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}