package es.localhost.javacomponent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML TextArea txtParametros;
    @FXML TextArea txtRespuesta;
    @FXML Button btBEnviarConsulta;
    @FXML ComboBox<String> listaOpciones;
    @FXML TextField Ruta;
    private final Operador op = new Operador();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("POST", "PUT", "GET", "DELETE");
        listaOpciones.setItems(items);
        listaOpciones.setValue("POST");
    }
    @FXML
    public void cxxt(){
        if(listaOpciones.getValue().compareTo("POST") == 0 || listaOpciones.getValue().compareTo("PUT") == 0)txtParametros.setDisable(false);
        else txtParametros.setDisable(true);
    }
    @FXML
    public void EjecutarConsulta(){
        switch (listaOpciones.getValue()){
            case "POST":{
                txtRespuesta.setText(op.post(Ruta.getText(),txtParametros.getText()));
                break;
            } case "PUT":{
                txtRespuesta.setText(op.put(Ruta.getText(), txtParametros.getText()));

            } case "GET":{
                txtRespuesta.setText(op.get(Ruta.getText()));
                break;
            } case "DELETE":{
                txtRespuesta.setText(op.delete(Ruta.getText()));
                break;
            }
        }
    }
}