import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] d = new int[n];

        int k = (int) Math.ceil((n + 1) / 2.0)-1;
        for (int i = 0; i < k+1; i++) {
            d[i] = scan.nextInt();
        }
        int ans=d[k];
        System.out.println(ans);
    }
}
