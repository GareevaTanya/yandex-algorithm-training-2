import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int[] n = new int[str.length()];
        if (str.charAt(0) == '(') {
            n[0] = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    n[i] = n[i - 1] + 1;
                } else {
                    n[i] = n[i - 1] - 1;
                }
                if (n[i] == -1) {
                    System.out.println("NO");
                    break;
                }
                if (i == n.length - 1 && n[i] == 0) {
                    System.out.println("YES");
                }else if (i == n.length - 1 && n[i] != 0){
                    System.out.println("NO");
                }
            }
        } else {
            System.out.println("NO");
        }

    }
}
