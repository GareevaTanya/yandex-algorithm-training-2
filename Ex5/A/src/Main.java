import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0;  i < a.length; i++) {
            a[i] = scan.nextInt();
        }
        int[][] lr = new int[q][2];
        for (int i = 0; i < lr.length; i++) {
            for (int j = 0; j < lr[i].length; j++) {
                lr[i][j]= scan.nextInt();
            }
        }
        long[] pref = new long[n+1];
        pref[0] = 0;
        for (int i = 1; i < pref.length; i++) {
            pref[i] = pref[i-1] + a[i-1];
        }

        for (int i = 0; i < lr.length; i++) {
            if (lr[i][0] == lr[i][1]){
                System.out.println(a[lr[i][0] - 1]);
            }else {
                long rez = pref[lr[i][1]] - pref[lr[i][0]-1];
                System.out.println(rez);
            }
        }
    }

}