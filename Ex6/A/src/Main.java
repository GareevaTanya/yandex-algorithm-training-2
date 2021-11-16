import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] n = new int[scan.nextInt()];
        for (int i = 0; i < n.length; i++) {
            n[i] = scan.nextInt();
        }

        int[][] k = new int[scan.nextInt()][2];
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                k[i][j] = scan.nextInt();
            }
        }

        Arrays.sort(n);
        for (int i = 0; i < k.length; i++) {
            int right = rbinsearch(k[i][1], n);
            int left = lbinsearch(k[i][0], n);
            if (right != left || (right == left && n[right] <= k[i][1] & n[right] >= k[i][0])) {
                System.out.print(right - left + 1 + " ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    public static int lbinsearch(int param, int[] n) {
        int l = 0;
        int r = n.length - 1;
        while (l < r) {
            int m = (int) ((l + r) / 2.0);
            if (n[m] >= param) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static int rbinsearch(int param, int[] n) {
        int l = 0;
        int r = n.length - 1;
        while (l < r) {
            int m = (int) ((l + r + 1) / 2.0);
            if (n[m] <= param) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
