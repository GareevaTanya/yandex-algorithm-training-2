import java.util.*;

import static java.util.Collections.max;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt() - 1;

        if (n!=1) {
            HashMap<Integer, Integer> treeBeads = new HashMap<>();
            HashSet<Integer> beadsSet = new HashSet<>();

            int b1 = scan.nextInt();
            int b2 = scan.nextInt();
            beadsSet.add(b1);
            beadsSet.add(b2);
            ArrayList<int[]> ostatki = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int bead1 = scan.nextInt();
                int bead2 = scan.nextInt();
                if (i == 0) {
                    if (b2 == bead1 || b2 == bead2) {
                        treeBeads.put(b1,b2);
                    }
                    if (b1 == bead1 || b1 == bead2) {
                        treeBeads.put(b2,b1);
                    }
                }
                if (beadsSet.contains(bead1)){
                    treeBeads.put(bead2,bead1);
                    beadsSet.add(bead2);
                }else if (beadsSet.contains(bead2)){
                    treeBeads.put(bead1,bead2);
                    beadsSet.add(bead1);
                }else {
                    ostatki.add(new int[]{bead1,bead2});
                }
            }
            while (ostatki.size()!=0){
                int bead1 = ostatki.get(0)[0];
                int bead2 = ostatki.get(0)[1];
                if (beadsSet.contains(bead1)){
                    treeBeads.put(bead2,bead1);
                    beadsSet.add(bead2);
                }else if (beadsSet.contains(bead2)){
                    treeBeads.put(bead1,bead2);
                    beadsSet.add(bead1);
                }else {
                    ostatki.add(new int[]{bead1,bead2});
                }
                ostatki.remove(0);
            }
            HashSet<Integer> ends = new HashSet<>(treeBeads.keySet());
            ends.removeAll(treeBeads.values());
            ArrayList<Integer> edgeToEdge = new ArrayList<Integer>();

            Integer[] end = ends.toArray(new Integer[0]);
            for (int i = 0; i < end.length-1; i++) {
                HashSet<Integer> relativeCurrentBead = new HashSet<Integer>();
                int bead1 = end[i];
                relativeCurrentBead.add(bead1);
                while (treeBeads.containsKey(bead1)){
                    bead1 = treeBeads.get(bead1);
                    relativeCurrentBead.add(bead1);
                }
                for (int j = i+1; j < end.length; j++) {
                    int lengthToRood = 1;
                    int bead2 = end[j];
                    int rood = bead1;
                    if (relativeCurrentBead.contains(bead2)){
                        rood = bead2;
                    }else {
                        while (treeBeads.containsKey(bead2)){
                            lengthToRood++;
                            bead2 = treeBeads.get(bead2);
                            if (relativeCurrentBead.contains(bead2)){
                                rood = bead2;
                                break;
                            }
                        }
                    }
                    bead1 = end[i];
                    if (bead1!=rood) {
                        while (treeBeads.containsKey(bead1)) {
                            lengthToRood++;
                            bead1 = treeBeads.get(bead1);
                            if (bead1 == rood){
                                break;
                            }
                        }
                    }
                    edgeToEdge.add(lengthToRood);

                }
            }
            max(edgeToEdge);
            System.out.println(max(edgeToEdge));
        }else {
            System.out.println(2);
        }
    }


}