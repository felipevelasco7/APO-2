package Seguimiento3.ui;
import java.util.Scanner;
import Seguimiento3.model.Main;

public class Turns {

    public static Scanner input=new Scanner(System.in);
    public static Main main;

    public static void main(String args[]) {
        Turns objMain= new Turns();
        main= new Main();
        menu();
    }

    public static void menu(){
        System.out.println();
        System.out.println("Menu: Ingrese el numero de la operacion que desea realizar");
        System.out.println("1. Dar turno.");
        System.out.println("2. Mostrar turno actual");
        System.out.println("3. Pasar turno");
        System.out.println("4. Seguir");
        System.out.println("5. Finalizar");
        String choice= input.nextLine();
        switch (choice) {
            case "1":
                main.addTurn();
                //System.out.println (main.print());
                menu();
                break;
            case "2":
                System.out.println (main.showActiveTurn());

                menu();
                break;
            case "3":
                System.out.println (main.skipTurn());
                menu();
                break;
            case "4":
                System.out.println (main.nextTurn());
                menu();
                break;
            case "5":
                System.out.println("Gracias");
                break;
            default: 
                System.out.println("Ingrese una opcion valida");
                menu();
        }
    }
}
