package com.example.threads;

import com.example.threads.model.Enemy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

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
    public ArrayList<Enemy> enemyArray;
    private int numberOfEnemies;
    private Timeline t1;
    private Image image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            image=new Image("https://i.pinimg.com/474x/55/c8/50/55c8508e84a265352253f3de3a832d6b.jpg");
//            String imagePath = "src/main/resources/images/img.png";
//            this.image = new Image(imagePath);
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        gc = canvas.getGraphicsContext2D();
        this.lives=3;
        this.numberOfEnemies=5;
        createEnemies();
        setCanvasEvents();


        t1=new Timeline(new KeyFrame(Duration.millis(10),e->play()));
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.play();


    }

    private void play() {

        if(lives<0) {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFill(Color.RED);
            gc.fillText("Juego finalizado\nPuntaje final: "+score,canvas.getWidth()/2, canvas.getHeight()/2);
            t1.stop();
            return;
        }
        lblLives.setText("" + lives);
        for (int i=0; i<enemyArray.size();i++) {//recorre el arreglo de enemigos
            Enemy enemy= enemyArray.get(i);
            boolean active=enemy.isActive();
            boolean killed=enemy.isKilled();
            boolean painted=enemy.isPainted();
            boolean ready=enemy.isReadyToErase();

            if (active && !killed &&!ready) { //esta vivo el enemigo y activo
                gc.setFill(Color.BLACK);
                gc.fillRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                gc.drawImage(image,enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                enemy.setPainted(true);
                //System.out.println("activo "+ enemy.getShape());
                //sale vivo y negro
            }
            else if(!active && !killed && painted && !ready){//si no le hicieron click antes de tiempo
                // el enemigo gano
                gc.setFill(Color.RED);
                gc.fillRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                enemy.setEndTime(1500+System.currentTimeMillis());
                lives--;
                //System.out.println("rojo"+ enemy.getShape());
                enemy.setReadyToErase(true);
                //sale rojo, listo para borrar y activo pq se le añadio tiempo
            }
            else if((!active && ready )|| killed) {//si el tiempo del enemigo acabo o si lo mataron
                //borrar
                System.out.println("fin"+ enemy.getShape());
                gc.clearRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                enemyArray.set(i,new Enemy(enemy.getTime()-120, gc)); //cada vez que se alimina a un enemigo, el siguiente disminuye su tiempo
                //System.out.println("new "+ enemyArray.get(i).getShape());

            }
        }
    }

    private void createEnemies() {
        enemyArray=new ArrayList<>();
        for (int i = 1; i <= numberOfEnemies; i++) {
            enemyArray.add(new Enemy(3000, gc)) ;
            System.out.println("creado "+ i);

        }
    }

    private void setCanvasEvents() {
        canvas.setFocusTraversable(true);
        canvas.setOnMouseClicked(event -> {
            Point2D point= new Point2D(event.getX(),event.getY());
            checkCollision(point);
        });
    }
    private void checkCollision(Point2D point) {
        for (Enemy enemy : enemyArray) {
            if (!enemy.isKilled() && enemy.isActive() && enemy.getShape().contains(point)&& !enemy.isReadyToErase()) {
                enemy.setKilled(true);
                System.out.println("Colission!");
                score += 10;
                lblScore.setText("" + score);
            }
        }

    }
}