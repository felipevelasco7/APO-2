package Seguimiento_5;
import java.util.Scanner;

public class Main {
    public static Scanner input=new Scanner(System.in);

    public static void main(String args[]) {
        BST bst = new BST();

        System.out.println("Ingrese los nombres en orden, separados por espacios");
        String names = input.nextLine();
        String[] array =names.split(" ");


        bst.addRoot(array);
        System.out.println("La profundidad maxima del arbol es: "+ bst.depth());
        bst.printFromRight();
    }

}
