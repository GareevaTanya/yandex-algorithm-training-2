import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int d = scan.nextInt();
        int Xx = scan.nextInt();
        int Xy = scan.nextInt();

        int Ax = 0;
        int Ay = 0;
        int Bx = d;
        int By = 0;
        int Cx = 0;
        int Cy = d;

        int ABx=Bx-Ax;//d
        int ABy=By-Ay;//0

        int AXx=Xx-Ax;//Xx
        int AXy=Xy-Ay;//Xy

        int ABxAX=ABx*AXy-ABy*AXx;//d*Xy

        int BCx=Cx-Bx;//-d
        int BCy=Cy-By;//d

        int BXx=Xx-Bx;//Xx-d
        int BXy=Xy-By;//Xy

        int BCxBX=BCx*BXy-BCy*BXx;//-d*Xy-d*(Xx-d)

        int CAx=Ax-Cx;//0
        int CAy=Ay-Cy;//-d

        int CXx=Xx-Cx;//Xx
        int CXy=Xy-Cy;//Xy-d

        int CAxCX=CAx*CXy-CAy*CXx;//d*Xx

        int ans;

        if (ABxAX>=0 & BCxBX>=0 & CAxCX>=0){
            ans=0;
        }else {
            double AX=Math.sqrt(Math.pow(AXx,2)+Math.pow(AXy,2));
            double BX=Math.sqrt(Math.pow(BXx,2)+Math.pow(BXy,2));
            double CX=Math.sqrt(Math.pow(CXx,2)+Math.pow(CXy,2));
            if (AX<=BX & AX<=CX){
                ans=1;
            }else {
                if (BX<AX & BX<=CX){
                    ans=2;
                }else {
                    ans=3;
                }
            }

        }
        System.out.println(ans);
    }
}
