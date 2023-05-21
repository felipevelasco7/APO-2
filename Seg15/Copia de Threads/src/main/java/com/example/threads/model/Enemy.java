package com.example.threads.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Enemy{
    private int x;
    private int y;
    private int size;
    private int time;
    private GraphicsContext gc;
    private Rectangle2D shape;
    private boolean killed;
    private long endTime;
    private long startTime;
    private boolean active;
    private boolean painted;


    public Enemy(int time, GraphicsContext gc) {
        Random random = new Random();
        this.startTime=System.currentTimeMillis()+ random.nextInt(9001) + 2000;;
        this.time=time;
        this.endTime=startTime+time;
        this.size = 20;
        this.x = random.nextInt((int) (gc.getCanvas().getWidth() - size));
        this.y = random.nextInt((int) (gc.getCanvas().getHeight() - size));
        this.gc = gc;
        shape=new Rectangle2D(x,y, size, size);
        this.killed =false;
        this.active =true;
        this.painted=false;
    }

//    public void run() {
//        //super.run();
//
//        while (!killed && System.currentTimeMillis() <= endTime){
//            gc.setFill(Color.BLACK);
//            gc.fillRect(x,y,size,size);
//        }
//        if(!killed) {
//            gc.setFill(Color.RED);
//            gc.fillRect(x,y,size,size);
//            neverClicked=true;
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        gc.clearRect(x,y,size,size);
//    }
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public Rectangle2D getShape() {
        return shape;
    }

    public void setShape(Rectangle2D shape) {
        this.shape = shape;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public boolean isActive() {
        if(startTime<=System.currentTimeMillis() && endTime>=System.currentTimeMillis()) active= true;
        else this.active=false;
        return active;
    }
    public void setActive(boolean notClicked) {
        this.active = notClicked;
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }
}
