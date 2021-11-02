import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a;
        int max = scan.nextInt();
        int i = 1;
        while ((a = scan.nextInt()) != 0) {
            if (max<a){
                max = a;
                i = 0;
            }
            if (max==a){
                i++;
            }
        }
        System.out.println(i);
    }
}