import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }

        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]==1){
                int k=1;
                while (i-k>=0 || i+k<=mas.length-1){
                    if ((i-k>=0 && mas[i-k]==2) || (i+k<=mas.length-1 && mas[i+k]==2)){
                        if (max<k){
                            max=k;
                        }
                        break;
                    }
                    k++;
                }
            }
        }
        System.out.println(max);
    }
}
