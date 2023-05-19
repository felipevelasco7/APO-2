package com.example.democanva.model;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Enemy extends Thread {
    private int x;
    private int y;
    private int size;
    private GraphicsContext gc;
    private Shape shape;
    private Canvas canvas;
    private volatile boolean running;

    public Enemy(int x, int y, int size, GraphicsContext gc, Canvas canvas) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.gc = gc;
        this.canvas = canvas;
        shape = new Rectangle(x, y, size, size);
        shape.setFill(Color.RED);
        running = true;
    }

    @Override
    public void run() {
        while (running) {
            Platform.runLater(() -> {
                gc.setFill(Color.RED);
                gc.fillRect(x, y, size, size);
            });

            canvas.setOnMouseClicked((MouseEvent event) -> {
                double clickX = event.getX();
                double clickY = event.getY();

                if (shape != null && shape.intersects(clickX, clickY, 1, 1)) {
                    Platform.runLater(() -> {
                        gc.clearRect(x, y, size, size);
                    });
                    shape = null;
                    running = false;
                }
            });

            try {
                // Delay between each frame update
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
