package com.example.demojavafx.threads_intro;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController1 implements Initializable {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private Player player;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc=canvas.getGraphicsContext2D();
        paint();
        player = new Player(100,100,30,3,gc);
        player.setDaemon(true);
        player.start();


    }
    private void paint(){
        gc.setFill(Color.BLACK);
        gc.fillRect(100,100,20,20);
    }
}
