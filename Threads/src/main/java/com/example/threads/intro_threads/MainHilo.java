package com.example.threads.intro_threads;

public class MainHilo {

    public static void main(String[] args){

//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                for (int i = 1; i <= 10; i++) {
//                    System.out.println("Hilo 1: "+i);
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                for (int i = 1; i <= 10; i++) {
//                    System.out.println("Hilo 2: "+i);
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        }.start();


        MiHilo hilo1 = new MiHilo("tarea1");
        hilo1.run();

        new MiHilo("tarea2").run();



    }

}
