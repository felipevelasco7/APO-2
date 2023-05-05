package com.example.cajafuerte.control;

import com.example.cajafuerte.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");


        User user= User.getInstance();
        user.setPassword("123456");
        welcomeText.isFocused();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}