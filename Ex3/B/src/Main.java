import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashSet<Integer> map = new HashSet<Integer>();
        ArrayList<String> ans = new ArrayList<>();
        while (scan.hasNext()){
            int a = scan.nextInt();
            if (map.contains(a)){
                ans.add("YES");
            }else{
                ans.add("NO");
                map.add(a);
            }
        }

        for (int i = 0; i < ans.size() ; i++) {
            System.out.println(ans.get(i));
        }

    }
}