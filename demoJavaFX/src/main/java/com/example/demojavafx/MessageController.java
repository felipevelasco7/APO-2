package com.example.demojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MessageController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}