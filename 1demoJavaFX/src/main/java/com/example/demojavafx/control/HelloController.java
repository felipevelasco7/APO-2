package com.example.demojavafx.control;

import com.example.demojavafx.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox checkTerminos;

    @FXML
    private RadioButton rbopcion1;

    @FXML
    protected void onHelloButtonClick() {
        boolean aceptoTerminos = checkTerminos.isSelected();
        String texto = "Welcome to JavaFX Application! option 1 is selected";
        if(!rbopcion1.isSelected()){
            texto = "Welcome to JavaFX Application! option 2 is selected";
        }
        if (!aceptoTerminos) texto = "Debe aceptar los términos y condiciones :)";
        welcomeText.setText(texto);
    }

    @FXML
    protected void onOpenWindow(){
        HelloApplication.hideWindow((Stage) welcomeText.getScene().getWindow());
        HelloApplication.showWindow("message-window");
    }
}