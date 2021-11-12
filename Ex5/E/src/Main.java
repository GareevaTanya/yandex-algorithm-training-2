import java.util.*;

import static java.util.Collections.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int n = scan.nextInt();
        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        ArrayList<Integer> aa = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt();
            if (a.containsKey(v) == false) {
                a.put(v, i);
                aa.add(v);
            }
        }

        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
        ArrayList<Integer> bb = new ArrayList<Integer>();
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt();
            if (b.containsKey(v) == false) {
                b.put(v, i);
                bb.add(v);
            }
        }
        HashMap<Integer, Integer> c = new HashMap<Integer, Integer>();
        ArrayList<Integer> cc = new ArrayList<Integer>();
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int v = scan.nextInt();
            if (c.containsKey(v) == false) {
                c.put(v, i);
                cc.add(v);
            }
        }
        int[] ans = new int[]{max(aa)+1,max(bb)+1,max(cc)+1};
        sort(aa);
        sort(bb);
        sort(cc, Collections.reverseOrder());
        for (int i = 0; i < aa.size(); i++) {
            int k = 0;
            int j = 0;
            while (j < bb.size() & k < cc.size()) {
                if (s - aa.get(i) == bb.get(j) + cc.get(k)) {
                    if (ans[0]>a.get(aa.get(i))){
                        ans[0]=a.get(aa.get(i));
                        ans[1]=b.get(bb.get(j));
                        ans[2]=c.get(cc.get(k));
                    }else if (ans[0]==a.get(aa.get(i)) && ans[1]>b.get(bb.get(j))) {
                        ans[1] = b.get(bb.get(j));
                        ans[2] = c.get(cc.get(k));
                    }else if (ans[0]==a.get(aa.get(i)) && ans[1]==b.get(bb.get(j)) && ans[2]>c.get(cc.get(k))){
                        ans[2] = c.get(cc.get(k));
                    }
                    j++;
                    k++;
                }else if (s - aa.get(i) > bb.get(j) + cc.get(k)) {
                    j++;
                } else if (s - aa.get(i) < bb.get(j) + cc.get(k)) {
                    k++;
                }
            }
        }

        if (ans[0]==max(aa)+1 && ans[1]==max(bb)+1 && ans[2]==max(cc)+1){
            System.out.println(-1);
        }else {
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }
}