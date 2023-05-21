package com.example.threads;

import com.example.threads.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    private Player player;

    private Rectangle obstacle;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        setCanvasEvents();
        paint();

    }

    private void setCanvasEvents() {
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.SPACE)){
                player.setMove(!player.isMove());
            }
            if (keyEvent.getCode().equals(KeyCode.UP)){
                System.out.println("up");
            }
            if (keyEvent.getCode().equals(KeyCode.DOWN)){
                System.out.println("down");
            }
        });
    }

    private void paint() {


        obstacle = new Rectangle(160,100, 30, 30);

        player = new Player(100,100,30,5, gc, obstacle);
        player.setDaemon(true); // IMPORTANTE!!! :)
        player.start();
    }
}