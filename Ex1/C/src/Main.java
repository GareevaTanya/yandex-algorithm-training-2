import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int d = scan.nextInt();
        int m = scan.nextInt();
        int y = scan.nextInt();

        int ans;

        if ((d > 12 ^ m > 12) || (d==m & d<=12)) {
            ans = 1;
        } else {
            ans = 0;
        }

        System.out.println(ans);
    }
}
