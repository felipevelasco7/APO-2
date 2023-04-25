import java.util.Scanner;

public class SushiForTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("numpieces");
        String num = sc.nextLine();
        int numOfPieces=Integer.parseInt(num);

        System.out.println("type");
        String typesOfSushi = sc.nextLine();

        String[] sushiType = typesOfSushi.split(" ");
        int tuna = 0;
        int eel = 0;
        int[] sushi = new int[numOfPieces];

        for (int i = 0; i < numOfPieces; i++) {
            sushi[i] = Integer.parseInt(sushiType[i]);
        }

        for (int element : sushi) {
            if(element==1) tuna++;
            else eel++;
        }
        int maxlenght=eel;
        if(tuna<eel) maxlenght=tuna;
        System.out.println(maxlenght*2);



    }
}






