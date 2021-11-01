import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int i = scan.nextInt();
        int j = scan.nextInt();

        int ans, r1, r2;

        if (i < j) {
            r1 = n - j + i - 1;
            r2 = j - i - 1;
            if (r1 <= r2) {
                ans = r1;
            } else {
                ans = r2;
            }
        }else {
            r1 = n - i + j - 1;
            r2 = i - j - 1;
            if (r1 <= r2) {
                ans = r1;
            } else {
                ans = r2;
            }
        }

        System.out.println(ans);
    }
}
