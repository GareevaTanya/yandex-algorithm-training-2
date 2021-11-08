import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        String bug = scan.nextLine();
        String[] witness = new String[m];
        for (int i = 0; i < witness.length; i++) {
            witness[i] = scan.nextLine();
        }

        int n = scan.nextInt();
        bug = scan.nextLine();
        String[] number = new String[n];

        for (int i = 0; i < number.length; i++) {
            number[i] = scan.nextLine();
        }
        int[] k = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            k[i] = check(witness,number[i]);
            if (k[i]>max){
                max=k[i];
            }
        }

        for (int i = 0; i < number.length; i++) {
            if (k[i] == max){
                System.out.println(number[i]);
            }
        }


    }

    public static int check (String[] witness, String number){

        int k = 0;
        HashSet<Character> hsNum = new HashSet<Character>();

        for (int i = 0; i < number.length(); i++) {
            hsNum.add(number.charAt(i));
        }

        for (int i = 0; i < witness.length; i++) {
            int b = 0;
            for (int j = 0; j < witness[i].length(); j++) {
                if (hsNum.contains(witness[i].charAt(j))){
                    b++;
                }

            }
            k = k+b/witness[i].length();
        }

        return k;
    }
}
