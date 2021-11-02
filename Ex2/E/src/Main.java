import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            ans = ans + a;
            if (max<a){
                max=a;
            }
        }
        System.out.println(ans-max);
    }
}