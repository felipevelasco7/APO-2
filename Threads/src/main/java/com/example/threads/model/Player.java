package com.example.threads.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Thread{

    private int x;
    private int y;
    private int size;
    private int movement;

    private GraphicsContext gc;

    private Rectangle shape;
    private Rectangle obstacle;

    private boolean move;
    private boolean horizontal;


    public Player(int x, int y, int size, int movement, GraphicsContext gc, Rectangle obstacle) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.movement = movement;
        this.gc = gc;
        this.obstacle = obstacle;
        move =true;
        horizontal = true;
        shape=new Rectangle(x,y,size,size);
    }

    @Override
    public void run() {
        super.run();
        while (true){
            gc.setFill(Color.RED);
            gc.fillRect(obstacle.getX(),obstacle.getY(),obstacle.getWidth(),obstacle.getHeight());
            gc.setFill(Color.BLACK);
            gc.fillRect(x,y,size,size);

            if (shape.intersects(obstacle.getBoundsInParent())) System.out.println("Colission!");

            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gc.clearRect(x,y,size,size);

            if(move){
                if((x+size+movement)>gc.getCanvas().getWidth() || x-movement<0){
                    horizontal=!horizontal;
                }

                if (horizontal) x+=movement;
                else x-=movement;
                shape.setX(x);
            }


        }
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

}
