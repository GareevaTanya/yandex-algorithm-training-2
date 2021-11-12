import java.util.*;

import static java.util.Collections.max;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();//кол-во групп
        int m = scan.nextInt();//кол-во аудиторий
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        int p = 0;//кол-во групп, которые получается распределить
        for (int i = 1; i <= n; i++) {
            x.add(scan.nextInt() + 1);
        }
        for (int i = 1; i <= m; i++) {
            y.add(scan.nextInt());
        }
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < n ; i++) {
            if (max(x) <= max(y)){
                result.put(x.indexOf(max(x))+1, y.indexOf(max(y))+1);
                x.set(x.indexOf(max(x)), 0);
                y.set(y.indexOf(max(y)), 0);
            }else {
                result.put(x.indexOf(max(x))+1,0);
                x.set(x.indexOf(max(x)), 0);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (result.get(i).equals(0)== false){
                p++;
            }
        }
        System.out.println(p);
        for (int i: result.keySet()){
            System.out.print(result.get(i) + " ");
        }

    }
}
