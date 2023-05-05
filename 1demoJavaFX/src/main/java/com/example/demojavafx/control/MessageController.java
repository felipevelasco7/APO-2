package com.example.demojavafx.control;

import com.example.demojavafx.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MessageController {

    @FXML
    private Label lblMessage;

    @FXML
    protected void onReturn(){
        HelloApplication.hideWindow((Stage) lblMessage.getScene().getWindow());
        HelloApplication.showWindow("hello-view");
    }

}