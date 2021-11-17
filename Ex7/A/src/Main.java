import java.util.Scanner;
import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = scan.nextInt();
            r[i] = scan.nextInt();
        }
        sort(l);
        sort(r);
        int[][] events = new int[n*2][2];
        int il = 0;
        int ir = 0;
        for (int i = 0; i < events.length; i++) {
            if (((il<l.length & ir < r.length) && r[ir]<=l[il]) ||
                    il>=l.length ){
                events[i][0] = r[ir];
                events[i][1] = -1;
                    ir++;
            }else if ((il<l.length & ir < r.length) && r[ir]>l[il]){
                events[i][0] = l[il];
                events[i][1] = 1;
                    il++;
            }
        }

        int line = 0;
        int element = events[0][0];
        long sum = 0;
        for (int i = 0; i < events.length; i++) {
            line = line + events[i][1];
            if (line==0){
                sum = sum + events[i][0] - element;
                if (i+1 < events.length){
                    element = events[i+1][0];
                }
            }
        }
        System.out.println(sum);


    }
}
