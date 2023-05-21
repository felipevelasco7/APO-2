package com.example.threads.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MiHilo extends Thread {
    public ArrayList<Enemy> enemyArray;
    private GraphicsContext gc;
    private int lives;


    public MiHilo(GraphicsContext gc, int numberOfEnemies){
        this.gc=gc;
        enemyArray=new ArrayList<>();
        for (int i = 1; i <= numberOfEnemies; i++) {
            enemyArray.add(new Enemy(3000, gc)) ;
            System.out.println("creado "+ i);

        }
        this.lives=3;
    }


    @Override
    public void run() {
        super.run();
        while (lives>=0){
            paint();
        }
        System.out.println("vidas :"+lives);

    }

    private void paint() {

        for (int i=0; i<enemyArray.size();i++) {//recorre el arreglo de enemigos
            Enemy enemy= enemyArray.get(i);
            if (enemy.isActive() && !enemy.isKilled() && System.currentTimeMillis() <= enemy.getEndTime() && System.currentTimeMillis() >= enemy.getStartTime()) { //esta vivo el enemigo y si el tiempo actual es menor que el de finalizacion y si el tiempo actual es mayor al de inicio
                //si esta activo
                gc.setFill(Color.BLACK);
                gc.fillRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                //System.out.println("activo "+ enemy.getShape());
                //sale vivo y negro
            }
            else if(enemy.isActive()&&!enemy.isKilled() && System.currentTimeMillis() >=enemy.getEndTime() ){//si no le hicieron click y se desaparecio
                //si el enemigo gano
                gc.setFill(Color.RED);
                gc.fillRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                enemy.setActive(false);
                enemy.setEndTime(System.currentTimeMillis()+1500);
                lives--;
                System.out.println("rojo"+ enemy.getShape());
                    //sale inactivo y rojo pero con tiempo
            }
            else if(enemy.getEndTime()<System.currentTimeMillis() || enemy.isKilled()) {//si el tiempo del enemigo acabo o si lo mataron
                //borrar
                System.out.println("fin"+ enemy.getShape());
                gc.clearRect(enemy.getX(), enemy.getY(), enemy.getSize(), enemy.getSize());
                enemyArray.set(i,new Enemy(enemy.getTime()-100, gc));
                System.out.println("new "+ enemyArray.get(i).getShape());
            }
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
