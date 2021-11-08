import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        HashSet<Integer> hashSet = new HashSet <Integer>();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        while (scan.hasNext()){
            int a = scan.nextInt();
            if (hashSet.contains(a)){
                if (ans.contains(a)){
                    ans.remove(ans.indexOf(a));
                }
            }else {
                hashSet.add(a);
                ans.add(a);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
