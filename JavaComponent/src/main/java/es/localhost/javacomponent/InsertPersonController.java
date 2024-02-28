package es.localhost.javacomponent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class InsertPersonController {
    @FXML
    private Label lTitulo;

    @FXML
    private void onHomeClick(){
        HelloController.loadNewScene("hello-view.fxml", lTitulo, "Home");
    }
    @FXML
    private void onModPersonClick(){
        HelloController.loadNewScene("update-person.fxml", lTitulo, "Update Person");
    }
    @FXML
    private void onModHouseClick(){
        HelloController.loadNewScene("update-house.fxml", lTitulo, "Update House");
    }
    @FXML
    private void onInsertHouseClick(){
        HelloController.loadNewScene("insert-house.fxml", lTitulo, "Insert House");
    }
    @FXML
    private void onDelPersonClick(){
        HelloController.loadNewScene("remov-person.fxml", lTitulo, "Remove Person");
    }
    @FXML
    private void onDelHouseClick(){
        HelloController.loadNewScene("remov-house.fxml", lTitulo, "Remove House");
    }

}
