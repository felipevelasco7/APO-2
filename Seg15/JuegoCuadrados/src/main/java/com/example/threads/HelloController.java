package com.example.threads;

import com.example.threads.model.Enemy;
import com.example.threads.model.MiHilo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Label lblScore;
    private int score;
    @FXML
    private Label lblLives;
    private int lives;
    private GraphicsContext gc;
    private MiHilo hilo1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        hilo1 = new MiHilo(gc,5);
        hilo1.setDaemon(true);
        setCanvasEvents();
        hilo1.start();

    }

    private void setCanvasEvents() {
        canvas.setFocusTraversable(true);
        canvas.setOnMouseClicked(event -> {
            Point2D point= new Point2D(event.getX(),event.getY());
            checkCollision(point);
        });
    }
    private void checkCollision(Point2D point) {
        for (Enemy enemy : hilo1.enemyArray) {
            if (!enemy.isKilled() && enemy.isActive() && enemy.getShape().contains(point)&& enemy.isActive()) {
                enemy.setKilled(true);
                System.out.println("Colission!");
                score += 10;
                lblScore.setText("" + score);
            }
        }

    }
}