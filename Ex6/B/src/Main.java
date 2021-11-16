import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] n = new int[scan.nextInt() + 1];
        n[0] = 0;
        for (int i = 1; i < n.length; i++) {
            n[i] = scan.nextInt();
        }

        int[] m = new int[scan.nextInt()];
        for (int i = 0; i < m.length; i++) {
            m[i] = scan.nextInt();
        }

        for (int i = 0; i < m.length; i++) {
            int right = rbinsearch(m[i], n);
            int left = lbinsearch(m[i], n);
            if (n[left] != m[i] || left>right ){
                System.out.println("0 0");
            }else {
                System.out.println(left + " " + right);
            }
        }
    }

    public static int lbinsearch(int param, int[] n) {
        int l = 1;
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
        int l = 1;
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
