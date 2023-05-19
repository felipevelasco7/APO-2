package com.example.democanva.control;

import com.example.democanva.model.Enemy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private List<Enemy> enemies;
    private int numOfEnemies;
    @FXML
    private Label lblScore;
    @FXML
    private Label lblLives;
    private int score=0;
    private int lives=3;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        enemies = new ArrayList<>();

        setCanvasEvents();

        Timeline enemyCreationTimeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> createEnemy())
        );
        enemyCreationTimeline.setCycleCount(Timeline.INDEFINITE);
        enemyCreationTimeline.play();
    }

    private void createEnemy() {
        if (numOfEnemies < 5) {
            Random random = new Random();
            int x = random.nextInt(200);
            int y = random.nextInt(200);
            Enemy enemy = new Enemy(x, y, 20, gc, canvas);
            enemy.start();

            enemies.add(enemy);
            numOfEnemies++;
        }
    }

    private void setCanvasEvents() {
        canvas.setFocusTraversable(true);
        canvas.setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();


            Iterator<Enemy> iterator = enemies.iterator();
            while (iterator.hasNext()) {
                Enemy enemy = iterator.next();
                if (enemy.isAlive() && enemy.getShape().intersects(clickX, clickY, 1, 1)) {
                    enemy.setRunning(false);
                    gc.clearRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                    score+=10;
                    lblScore.setText(""+score);
                    iterator.remove();
                    numOfEnemies--;
                    break; // Exit the loop after removing one enemy
                }
            }
        });
    }
}
