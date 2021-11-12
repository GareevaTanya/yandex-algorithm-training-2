import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[scan.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
        }
        long[] sum = new long[a.length+1];
        long max = a[0];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            long s = sum[i-1] + a[i-1];
            if (s >= a[i-1]){
                sum[i] = s;
            }else {
                sum[i] = a[i-1];
            }
            if (max < sum[i]){
                max = sum[i];
            }
        }
        System.out.println(max);
    }
}
