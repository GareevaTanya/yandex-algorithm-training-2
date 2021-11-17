import java.util.Scanner;
import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] t = new int[n];
        int[] l = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = scan.nextInt();
            l[i] = t[i] + scan.nextInt();
        }
        sort(t);
        sort(l);
        int[][] events = new int[n*2][2];
        int it = 0;
        int il = 0;
        for (int i = 0; i < events.length; i++) {
            if (((it<t.length & il < l.length) && l[il]<=t[it]) ||
                    it>=t.length ){
                events[i][0] = l[il];
                events[i][1] = -1;
                il++;
            }else if ((it<t.length & il < l.length) && l[il]>t[it]){
                events[i][0] = t[it];
                events[i][1] = 1;
                it++;
            }
        }

        long max = 0;
        int line = 0;
        for (int i = 0; i < events.length; i++) {
            line = line + events[i][1];
            if (line>max){
                max = line;
            }
        }
        System.out.println(max);


    }
}
