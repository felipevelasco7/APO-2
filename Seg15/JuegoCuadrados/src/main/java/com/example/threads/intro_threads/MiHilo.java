package com.example.threads.intro_threads;

public class MiHilo extends Thread {

    private String nombreTarea;

    public MiHilo(String nombreTarea){
        this.nombreTarea=nombreTarea;
    }

    @Override
    public void run() {
        super.run();
        executeTask();
    }

    private void executeTask() {
        System.out.println("Inicio tarea: "+nombreTarea);
        try {
            sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fin tarea: "+nombreTarea);
    }
}
