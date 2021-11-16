import java.util.Scanner;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] n = new int[scan.nextInt()];
        int k = scan.nextInt();
        for (int i = 0; i < n.length; i++) {
            n[i] = scan.nextInt();
        }
        long left = 0;
        sort(n);
        long right = (abs(n[0]) + abs(n[n.length-1]))/k + 1;

        while (left < right) {
            long l = (left + right) / 2;
            int cnt = 0;
            long maxright = n[0] - 1;
            for (int i = 0; i < n.length; i++) {
                if (n[i]>maxright){
                    cnt++;
                    maxright = n[i] + l;
                }
            }
            if (cnt<=k) {
                right = l;
            } else {
                left = l+1;
            }

        }
        System.out.println(left);
    }
}
