import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        TreeMap<Long,Long> da = new TreeMap<Long,Long>();

        for (int i = 0; i < n; i++) {
            long d = scan.nextLong();
            long a = scan.nextLong();
            if (da.containsKey(d)){
                a = a+da.get(d);
            }
            da.put(d,a);
        }

        for (Map.Entry entry: da.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}