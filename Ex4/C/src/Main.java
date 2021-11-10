import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, Integer> dictionary = new TreeMap<String,Integer>();

        int maxkey = 1;
        while (scan.hasNext()){
            String[] str = scan.nextLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                int k = 1;
                if (dictionary.containsKey(str[i])) {
                    k = dictionary.get(str[i]) + 1;
                }
                dictionary.put(str[i], k);
                if (maxkey<k){
                    maxkey = k;
                }
            }
        }

        for (int i = maxkey; i > 0 ; i--) {
            for (Map.Entry entry: dictionary.entrySet()){
                if (entry.getValue().equals(i)){
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
