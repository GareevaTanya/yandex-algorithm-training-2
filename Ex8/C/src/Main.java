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
            String child1 = scan.next();
            String child2 = scan.next();
            relative(tree,child1,child2);
        }
    }

    public static void relative(HashMap<String, String> tree,String child1, String child2) {
        HashSet<String> relativeChild1Set = new HashSet<String>();
        relativeChild1Set.add(child1);
        while (tree.containsKey(child1)){
            child1 = tree.get(child1);
            relativeChild1Set.add(child1);
        }
        if (relativeChild1Set.contains(child2)){
            System.out.println(child2);
        }else {
            while (tree.containsKey(child2)){
                child2 = tree.get(child2);
                if (relativeChild1Set.contains(child2)){
                    System.out.println(child2);
                    break;
                }
            }
        }

    }
}