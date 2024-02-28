package es.localhost.javacomponent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {




    public static void loadNewScene(String nScene, Label label, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloController.class.getResource(nScene));
            Parent root = loader.load();

            // Get the current Stage
            Stage stage = (Stage) label.getScene().getWindow();
            stage.setTitle(title);

            // Create a new scene
            Scene scene = new Scene(root);

            // Set the new scene to the Stage
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void showAlert(String title, String textHeader, String textContent, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(textHeader);
        alert.setContentText(textContent);
        alert.showAndWait();
    }
}