import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int l = scan.nextInt();
        int n = scan.nextInt();
        int[] mas = new int[n];
        int c1 = (int) Math.floor((l - 1) / 2.0);
        int c2 = (int) Math.ceil((l - 1) / 2.0);
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
            if (mas[i]<=c1){
                i1 = i;
            }
        }
        for (int i = mas.length-1; i >=0 ; i--) {
            if (mas[i]>=c2){
                i2 = i;
            }
        }

        if (i1 == i2){
            System.out.println(mas[i1]);
        }else {
            System.out.println(mas[i1] + " " + mas[i2]);
        }


    }
}
