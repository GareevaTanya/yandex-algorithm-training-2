import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        double left = -2000.0;
        double right = 2000.0;

        while (left + 0.000000001 < right) {
            double m = (left + right) / 2.0;
            if (check(a, b, c, d, m)) {
                left = m;
            } else {
                right = m;
            }
        }
        System.out.println(left);
    }

    public static boolean check (double a, double b, double c, double d, double m){
        boolean flag;
        if (a>0){
            flag = (a * pow(m, 3) + b * pow(m, 2) + c * m + d <= 0);
        }else  flag = (a * pow(m, 3) + b * pow(m, 2) + c * m + d >= 0);
        return flag;
    }
}
