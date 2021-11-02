import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int a = (int) Math.floor(s.length() / 2.0);
        int ans = 0;

        for (int i = 0; i < a; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}