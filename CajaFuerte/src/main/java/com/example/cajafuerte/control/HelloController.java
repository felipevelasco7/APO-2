package com.example.cajafuerte.control;

import com.example.cajafuerte.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert; //Alert alert=new Alert(Alert.AlertType.INFORMATION)
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    private PasswordField[] passwordFields = new PasswordField[6];
    private int currentFieldIndex ;
    @FXML
    private Button abrirButton;
    @FXML
    private PasswordField pf1;
    @FXML
    private PasswordField pf2;
    @FXML
    private PasswordField pf3;
    @FXML
    private PasswordField pf4;
    @FXML
    private PasswordField pf5;
    @FXML
    private PasswordField pf6;
    @FXML
    protected void p1KeyTyped() {
        welcomeText.setText("Welcome to JavaFX Application!");


        User user= User.getInstance();
        user.setPassword("123456");
        welcomeText.isFocused();

    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        User user= User.getInstance();
        user.setPassword("123456");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User user= User.getInstance();
        user.setPassword("123456");

        passwordFields[0] = pf1;
        passwordFields[1] = pf2;
        passwordFields[2] = pf3;
        passwordFields[3] = pf4;
        passwordFields[4] = pf5;
        passwordFields[5] = pf6;
        passwordFields[0].requestFocus();
        currentFieldIndex=0;
    }

    public void onKeyTyped(KeyEvent keyEvent) {
        PasswordField passwordField= (PasswordField) keyEvent.getSource();
        String character = keyEvent.getCharacter();
        if (character.matches("[0-9]") && passwordField.getText().length() < 1) {
            passwordField.setText(character);
            keyEvent.consume();
            focusNextField();
        }
    }
    public void onKeyPressed(KeyEvent keyEvent) {
        PasswordField passwordField= (PasswordField) keyEvent.getSource();
        if (keyEvent.getCode() == KeyCode.BACK_SPACE && passwordField.getText().isEmpty()) {
            keyEvent.consume();
            focusPreviousField();
        } else if (keyEvent.getCode() == KeyCode.BACK_SPACE && !passwordField.getText().isEmpty()) passwordField.setText("");
    }
    private void focusNextField() {
        if (currentFieldIndex < passwordFields.length-1) {
            currentFieldIndex++;
            passwordFields[currentFieldIndex].requestFocus();
        } else if (currentFieldIndex== passwordFields.length) abrirButton.requestFocus();
    }
    private void focusPreviousField() {
        if (currentFieldIndex > 0) {
            currentFieldIndex--;
            passwordFields[currentFieldIndex].requestFocus();
        }
    }

    public void onAbrirButton(ActionEvent actionEvent) {
    }
}