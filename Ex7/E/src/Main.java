import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[][] events = new double[n*2][3];

        double maxr1 = scan.nextDouble();
        double minr2 = scan.nextDouble();

        events[0][0] = scan.nextDouble();
        events[0][1] = 1.0;
        events[0][2] = 0;
        events[1][0] = scan.nextDouble();
        events[1][1] = -1.0;
        events[1][2] = 0;

        for (int i = 2; i < n*2; i += 2) {
            double r1 = scan.nextDouble();
            double r2 = scan.nextDouble();
            if (r1>maxr1){
                maxr1 = r1;
            }
            if (r2<minr2){
                minr2 = r2;
            }

            events[i][0] = scan.nextDouble();
            events[i][1] = 1.0;
            events[i][2] = i/2;
            events[i+1][0] = scan.nextDouble();
            events[i+1][1] = -1.0;
            events[i+1][2] = i/2;
        }
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? Double.compare (a[1],b[1]) : Double.compare (a[0],b[0]));

        if (maxr1<minr2){
            int counter = 0;
            HashSet<Integer> fn = new HashSet<Integer>();
            for (int i = 0; i < events.length; i++) {
                if(events[i][1]==1){
                    counter = counter + (int) events[i][1];
                    fn.add((int) events[i][2]);
                }else {
                    if (fn.contains((int) events[i][2])) {
                        counter--;
                        fn.remove(events[i][2]);
                    }
                }
            }
            double s = 0.0;

            for (int i = 0; i < events.length; i++) {
                if (counter == n) {
                    double f1;
                    double f2 = events[i][0];
                    if (i!=0){
                        f1 = events[i-1][0];
                    }else {
                        f1 = 0.0;
                    }
                    s = s + (abs((f2 - f1)/2.0)*pow(minr2,2) - (abs(f2 - f1)/2.0)*pow(maxr1,2));
                }
                if(events[i][1]==1){
                    counter++;
                }else {
                    counter--;
                }
                if (i == events.length -1 && counter == n){
                    double f2 = 2*PI;
                    double f1 = events[i][0];
                    s = s + (((f2 - f1)/2.0)*pow(minr2,2) - ((f2 - f1)/2.0)*pow(maxr1,2));
                }
            }
            System.out.println(s);
        }else {
            System.out.println(0);
        }

    }
}
