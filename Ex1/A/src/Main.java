import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        byte r = scan.nextByte();
        byte i = scan.nextByte();
        byte c = scan.nextByte();

        int ans;
        switch (i) {
            case 0:
                if (r==0){
                    ans=c;
                }else {
                    ans=3;
                }
                break;
            case 1:
                ans=c;
                break;
            case 4:
                if (r==0){
                    ans=4;
                }else {
                    ans=3;
                }
                break;
            case 6:
                ans=0;
                break;
            case 7:
                ans=1;
                break;
            default:
                ans=i;
                break;
        }

        System.out.println(ans);
    }
}