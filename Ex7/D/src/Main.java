import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[][] events = new int[n + m * 2][3];
        for (int i = 0; i < n; i++) {
            events[i][0] = scan.nextInt();
            events[i][1] = 2;
            events[i][2] = 1;
        }

        int ilr = n;
        for (int i = 0; i < m; i++) {
            events[ilr][0] = scan.nextInt();
            events[ilr][1] = 1;
            events[ilr][2] = i;
            ilr++;
            events[ilr][0] = scan.nextInt();
            events[ilr][1] = 3;
            events[ilr][2] = i;
            ilr++;
        }

        Arrays.sort(events, (a, b) -> a[0] == b[0] ? Integer.compare (a[1],b[1]) : Integer.compare (a[0],b[0]));
        int[] catsum = new int[m];
        int cat = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i][1] != 2) {
                catsum[events[i][2]] = cat - catsum[events[i][2]];
            }
            if (events[i][1] == 2) {
                cat++;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(catsum[i]);
        }
    }
}
