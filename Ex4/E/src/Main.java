import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        LinkedHashMap<String, HashSet<Integer>> topic = new LinkedHashMap<String, HashSet<Integer>>();
        for (int i = 1; i <= n; i++) {
            int a = scan.nextInt();
            String bug = scan.nextLine();
            String massage = scan.nextLine();
            if (a == 0) {
                HashSet<Integer> body = new HashSet<Integer>();
                body.add(i);
                topic.put(massage, body);
                massage = scan.nextLine();
            } else {
                for (Map.Entry entry : topic.entrySet()) {
                    HashSet body = (HashSet) entry.getValue();
                    if (body.contains(a)) {
                        body.add(i);
                        topic.put(String.valueOf(entry.getKey()), body);
                    }
                }
            }
        }
        int maxBody = 0;
        for (Map.Entry entry : topic.entrySet()) {
            if (((HashSet<?>) entry.getValue()).size() > maxBody) {
                maxBody = ((HashSet) entry.getValue()).size();
            }
        }
        for (Map.Entry entry : topic.entrySet()) {
            if (((HashSet<?>) entry.getValue()).size() == maxBody) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}

