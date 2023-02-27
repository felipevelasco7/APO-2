package Seguimiento4_ABB.src.ui;
import java.util.Scanner;
import Seguimiento4_ABB.src.model.Controler;

public class Main {
    public static Scanner input=new Scanner(System.in);
    public static Controler controler;
    
    public static void main(String args[]) {
        Main objMain= new Main();
        controler= new Controler();
        menu();

        String palabra1= "abc";
        String palabra2= "abd";
        System.out.print( palabra1.compareTo(palabra2));
    }

    public static void menu(){
        System.out.println();
        System.out.println("Menu: Ingrese el numero de la operacion que desea realizar");
        System.out.println(" 1. Agregar registro \n 2. Buscar registro por puntaje \n 3. Jugadores por orden alfabético \n 4. Ver TOP 5 puntajes \n 5. Salir");
        String choice= input.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Ingrese el nombre de usuario");
                String username= input.nextLine();
                System.out.println("Ingrese el puntaje");
                int score= input.nextInt();
                input.nextLine();
                controler.addScoreRegistry(username, score);
                menu();
                break;
            case "2":
                System.out.println("Ingrese el puntaje para buscar");
                int scoreToSearch= input.nextInt();
                input.nextLine();
                controler.searchByScore(scoreToSearch);
                menu();
                break;
            case "3":
                controler.alphabeticalOrder();
                menu();
                break;
            case "4":
                controler.top5();
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
