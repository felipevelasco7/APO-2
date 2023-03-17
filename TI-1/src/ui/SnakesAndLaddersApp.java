package ui;
import model.Controler;
import java.util.Scanner;


public class SnakesAndLaddersApp{
    public static Scanner input=new Scanner(System.in);
    public static Controler controler;

    public static void main(String args[]) {
        SnakesAndLaddersApp objMain= new SnakesAndLaddersApp();
        controler= new Controler();
        //menu();

        controler.generateBoard(5, 5, 4, 4);
        
    }

    public static void menu(){
        System.out.println("Menu: Ingrese el numero de la operacion que desea realizar \n 1. Jugar \n 2. Salir");
        String option=input.nextLine();
        switch(option){
            case "1":
                
                play();
                menu();
                break;
            case "2":
                System.out.println("Gracias por jugar");
                break;
            default:
                System.out.println("Ingrese una opcion valida del menu");
                menu();
        }
    }

    public static void play(){
        generateBoard();
        long startTime = System.currentTimeMillis();


        int currentPlayer = 0; 
        int numPlayers = 3; 

        while(!controler.checkwinner()){
            turnMenu(currentPlayer);
            currentPlayer = (currentPlayer + 1) % numPlayers;

        }
        long endTime = System.currentTimeMillis();
        System.out.println(controler.calculateScore(endTime, startTime, currentPlayer));
        
    }

    public static void turnMenu(int currentPlayer){
        String player;
        if(currentPlayer==0) player="$";
        if(currentPlayer==1) player="%";
        else player="&";
        System.out.println("Jugador "+ player +", es tu turno /n 1. Tirar dado \n 2. Ver escaleras y serpientes");
        String option=input.nextLine();

            switch(option){
                case "1":
                    int num= controler.throwDice();
                    System.out.println("El numero tirado es: "+num);
                    controler.move(num, player);
                    System.out.println(controler.showBoard());
                    break;
                case "2":
                    System.out.println(controler.showSnakesAndLadders());
                    turnMenu(currentPlayer);
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    turnMenu(currentPlayer);
                    
            }
    }


    public static void generateBoard(){
        System.out.println("Ingrese el numero de columnas (x)");
        int n=input.nextInt();        input.nextLine();
        System.out.println("Ingrese el numero de filas (y)");
        int m=input.nextInt();        input.nextLine();
        System.out.println("Ingrese el numero de serpientes");
        int s=input.nextInt();        input.nextLine();
        System.out.println("Ingrese el numero de escaleras");
        int e=input.nextInt();        input.nextLine();
        System.out.println(controler.generateBoard(n,m,s,e));

    }
    

}