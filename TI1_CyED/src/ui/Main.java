package ui;
import model.Controller;
import java.util.Scanner;
public class Main {
    public static Scanner input=new Scanner(System.in);
    public static Controller controller;

    public static void main(String[] args) throws Exception{

        controller= new Controller();
        menu();
    }
    public static void menu() throws Exception{
        System.out.println("Menu");
        String opt=" ";
        while (!opt.equalsIgnoreCase("1")) {
            System.out.println("Ingrese el numero de la opcion que desea realizar: \n  1.Cargar Pasajeros ");
            opt=input.nextLine();
        }
        System.out.println(controller.loadInfo("Data.txt"));

        while (!opt.equalsIgnoreCase("2")) {
            System.out.println("Ingrese el numero de la opcion que desea realizar: \n 2.Registrar llegadas");
            opt=input.nextLine();
        }
        System.out.println(controller.readArrivals());

        while (!opt.equalsIgnoreCase("3")) {
            System.out.println("Ingrese el numero de la opcion que desea realizar: \n 3.Abrir Puertas (Mostrar orden de entrada)");
            opt=input.nextLine();
        }

        System.out.println("Orden de entrada: \n Nombre Id fila asiento "+controller.showBoardingOrder());

        while (!opt.equalsIgnoreCase("4")) {
            System.out.println("Ingrese el numero de la opcion que desea realizar: \n 4. Mostrar orden de Salida");
            opt=input.nextLine();
        }
        System.out.println("Orden de salida: \n Nombre Id fila asiento "+controller.showUnboardingOrder());

    }
}