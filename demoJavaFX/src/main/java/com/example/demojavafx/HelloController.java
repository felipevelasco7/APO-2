package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private ColorPicker colorPkr;

    @FXML
    private CheckBox okcheckBox;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onColorPicker() {

        // welcomeText.setTextFill(colorPkr.getValue());
    }


    public void okCheckBox() {
        welcomeText.setTextFill(colorPkr.getValue());
        okcheckBox.setSelected(false);


    }
}


