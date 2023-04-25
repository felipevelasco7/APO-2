import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] parts = s.split("\\+");

        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        //Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        StringBuilder new_sum = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            new_sum.append(arr[i]);
            if (i != arr.length - 1) new_sum.append("+");

        }

        System.out.println(new_sum);

    }
}