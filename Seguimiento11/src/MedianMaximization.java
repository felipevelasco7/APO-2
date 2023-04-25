import java.util.Scanner;

public class MedianMaximization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String tString = sc.nextLine();
        int t=Integer.parseInt(tString);

        String[] inputs = new String[t];
        for (int i = 0; i < t; i++) {
            inputs[i] = sc.nextLine();
        }

        for (String element : inputs) {
            String[] sn = element.split(" ");
            int s=Integer.parseInt(sn[1]);
            int n=Integer.parseInt(sn[0]);
            int medianIndex = (int) Math.ceil(n/ (double) 2)-1;
            int m=n;
            int[] array = new int[n];

            for (int i = 0; i < m; i++) {
                int num = (int) Math.floor(s/(double) n);
                n--;
                array[i] = num;
                s=s-num;
            }
            System.out.println(array[medianIndex]);

        }
    }

}






