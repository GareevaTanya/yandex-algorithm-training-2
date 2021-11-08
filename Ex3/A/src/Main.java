import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String a[] = scan.nextLine().split(" ");
        String b[] = scan.nextLine().split(" ");

        HashMap<String,Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i],1);
        }
        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
                map.put(b[i],2);
            }
        }
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) == 2) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}