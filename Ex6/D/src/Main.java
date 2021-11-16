import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        long k = scan.nextLong();
        int b = scan.nextInt();
        long m = scan.nextLong();
        long x = scan.nextLong();
        long r = x * 2 / ((a+b)/2) + 1;
        long l = 0;
        while (l < r) {
            long d = (l + r) / 2;
            long hd = d / k;
            long hf = d / m;
            if ((d - hd) * a + (d - hf) * b < x) {
                l = d + 1;
            } else {
                r = d;
            }
        }
        System.out.println(l);
    }
}
