import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        TreeMap<String,Integer> top = new TreeMap<String,Integer>();

        while (scan.hasNext()) {
            String[] str = scan.nextLine().split(" ");
            String name = str[0];
            int k = Integer.parseInt(str[1]);
            if (top.containsKey(name)) {
                k = k + top.get(name);
            }
            top.put(name, k);
        }

        for (Map.Entry entry: top.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
