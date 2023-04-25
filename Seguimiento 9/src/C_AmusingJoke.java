import java.util.ArrayList;
import java.util.Scanner;

public class C_AmusingJoke {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        name+= sc.nextLine();
        String letters = sc.nextLine();

        ArrayList<Character> array = new ArrayList<>();
        ArrayList<Character> lettersArray = new ArrayList<>();

        for (int i = 0; i < name.length(); i++) {
            array.add(name.charAt(i));
        }

        for (int i = 0; i < letters.length(); i++) {
            lettersArray.add(letters.charAt(i));
        }

        sortIntegerArrayBubble(array);
        sortIntegerArrayBubble(lettersArray);

        if(array.equals(lettersArray)) System.out.println("YES");
        else System.out.println("NO");

    }
    private static void sortIntegerArrayBubble(ArrayList<Character> array){
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size()-i; j++) {
                if(array.get(j).compareTo(array.get(j-1))<0){
                    // get values to swap
                    char anterior = array.get(j-1);
                    char actual = array.get(j);
                    // swap
                    array.set(j,anterior);
                    array.set(j-1,actual);
                }
            }

        }
    }
}