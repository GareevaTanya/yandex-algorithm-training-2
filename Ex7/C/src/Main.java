import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();

        TreeMap<Integer, Integer> lr = new TreeMap<Integer, Integer>();
        int li = scan.nextInt();
        int ri = scan.nextInt();
        while (li != 0 || ri != 0) {
            if ((li < m && ri > 0) && (lr.containsKey(li) == false || lr.containsKey(li) && ri > lr.get(li))) {
                lr.put(li, ri);
            }
            li = scan.nextInt();
            ri = scan.nextInt();
        }

        TreeMap<Integer, Integer> ans = new TreeMap<Integer, Integer>();
        int l = 0;
        int[] point = new int[]{0, 0};
        for (Map.Entry entry : lr.entrySet()) {
            if ((int) entry.getKey() > l) {
                l = point[1];
                if (point[0] == 0 && point[1] == 0) {
                    ans.clear();
                    break;
                } else {
                    ans.put(point[0], point[1]);
                    point[0] = 0;
                    point[1] = 0;
                }
            }
            if (l < m && (int) entry.getKey() <= l) {
                if (point[1] < (int) entry.getValue()) {
                    point[0] = (int) entry.getKey();
                    point[1] = (int) entry.getValue();
                }
            }
        }
        if ((point[0] != 0 || point[1] != 0) & point[1] >=m) {
            ans.put(point[0], point[1]);
        }

        if (ans.size() >= 1) {
            System.out.println(ans.size());
            for (Map.Entry entry : ans.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }else if (ans.size() == 0){
            System.out.println("No solution");
        }

    }
}
