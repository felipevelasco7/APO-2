package ui;
import model.Main;
import java.util.Scanner;

public class TriviaApp{
    public static Scanner input=new Scanner(System.in);
    public static Main main;

    public static void main(String args[]) {
        TriviaApp objMain= new TriviaApp();
        main= new Main();
        
        start();
    }

    public static void start(){
        /* 
        System.out.println ("Trivia Matematica");
        System.out.println ("Ingrese su nombre: ");
        String nickname= input.nextLine();
        System.out.println ("Ingrese el numero de preguntas que desea responder: ");
        int numberOfQuestions= input.nextInt();
        */
        main.createLinkedList(4, "nickname");

        main.start();
        String answer= input.nextLine();
        main.check(answer);

    }
    
}