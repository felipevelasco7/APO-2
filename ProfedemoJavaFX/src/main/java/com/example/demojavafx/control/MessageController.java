package com.example.demojavafx.control;

import com.example.demojavafx.HelloApplication;
import com.example.demojavafx.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MessageController implements Initializable {

    public MessageController(){
        // Esto falla porque el constructor se ejecuta antes de que los fxml se han cargado, para ello se implementa la interfaz "Initializable" con su metodo initialize
        //lblMessage.setText("hola");

    }

    @FXML
    private Label lblMessage;

    @FXML
    protected void onReturn(){

        System.out.println(User.getInstance().getUsername());

        HelloApplication.hideWindow((Stage) lblMessage.getScene().getWindow());
        HelloApplication.showWindow("hello-view");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblMessage.setText("hola");

    }

    @FXML
    protected void onInfo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Cabecera");
        alert.setTitle("Info");
        alert.setContentText("Informacion sobre la aplicación");
        alert.showAndWait();
    }

    @FXML
    protected void onError(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Cabecera");
        alert.setTitle("Info");
        alert.setContentText("Error en la aplicación");
        alert.showAndWait();
    }

    @FXML
    protected void onConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Cabecera");
        alert.setTitle("Info");
        alert.setContentText("¿Desea realmente confirmar? volverá al menu principal");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                onReturn();
            }
        });
    }
}