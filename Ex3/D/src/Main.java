import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 1; i <= a; i++) {
            hashMap.put(i, 0);
        }
        String bag = scan.nextLine();

        int key = 0;

        while (scan.hasNextInt()){
           String[] str = scan.nextLine().split(" ");
           String status = scan.nextLine();

            if (status.equals("NO")){
                metodNO(hashMap,str);
            }
            if (status.equals("YES")){
                key++;
                metodYES(hashMap,str);
            }
        }

        for (int i = 1; i < a; i++) {
            if (hashMap.get(i).equals(key)){
                System.out.print(i + " ");
            }
        }

    }

    public static void metodNO (HashMap hashMap, String[] str){
        for (int i = 0; i < str.length; i++) {
            hashMap.put(Integer.parseInt(str[i]),-1);
        }
    }
    public static void metodYES (HashMap hashMap, String[] str){
        for (int i = 0; i < str.length; i++) {
            if (hashMap.get(Integer.parseInt(str[i])).equals("-1") == false) {
                int a = (int) hashMap.get(Integer.parseInt(str[i]));
                hashMap.put(Integer.parseInt(str[i]), a+1);
            }
        }
    }
}
