import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt() - 1;

        HashMap<String, String> tree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String child = scan.next();
            String parent = scan.next();
            tree.put(child, parent);
        }
        while (scan.hasNext()) {
            String relative1 = scan.next();
            String relative2 = scan.next();
            relative(tree,relative1,relative2);
        }
    }

    public static void relative(HashMap<String, String> tree,String relative1, String relative2) {
        if (IsChild(tree,relative1,relative2)){
            System.out.print(2 + " ");
        }else if (IsChild(tree,relative2,relative1)){
            System.out.print(1 + " ");
        }else {
            System.out.print(0 + " ");
        }

    }
    public static boolean IsChild (HashMap<String, String> tree,String child, String parens){
        while (tree.containsKey(child)){
            child = tree.get(child);
            if (child.equals(parens)){
                return true;
            }
        }
        return false;
    }
}