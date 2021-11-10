import java.util.*;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Long> list = new LinkedHashMap<String, Long>();
        long sumTicket = 0;
        while (scan.hasNext()){
            String[] str = scan.nextLine().split(" ");
            long ticket = Long.parseLong(str[str.length-1]);
            sumTicket = sumTicket + ticket;
            String name = str[0];
            for (int i = 1; i < str.length-1; i++) {
                name = name + " " + str[i];
            }
            if (list.containsKey(name)) {
                ticket = ticket + list.get(name);
            }
            list.put(name, ticket);
        }



        int[][] a = new int[list.size()][2];
        int k = 450;
        int i = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry entry: list.entrySet()) {
            a[i][0]= (int) ((long) (entry.getValue()) * 450.0 / sumTicket);
            a[i][1]= (int) ((long) (entry.getValue()) * 450.0 - a[i][0]*sumTicket);
            arrayList.add(a[i][1]);
            k = k-a[i][0];
            i++;
        }
        sort(arrayList, Collections.reverseOrder());

        for (int j = 0; j < k; j++) {
            for (int l = 0; l < list.size(); l++) {
                if (arrayList.get(j) == a[l][1]){
                    a[l][0] = a[l][0] + 1;
                }
            }
        }
        i = 0;
        for (Map.Entry entry: list.entrySet()) {
            System.out.println( entry.getKey() + " " +a[i][0]);
            i++;
        }


    }
}
