package com.example.demojavafx.threads_intro;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Thread{
    private int x;
    private int y;
    private int size;
    private int movement;
    private GraphicsContext gc;

    public Player(int x, int y, int size, int movement, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.movement = movement;
        this.gc=gc;
    }

    @Override
    public void run(){
        super.run();
        while (true) {
            gc.setFill(Color.BLACK);
            gc.fillRect(x,y,size,size);
            try {
                sleep(500);

            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            gc.clearRect(x,y,size,size);
            x+=movement;
        }
    }
}
