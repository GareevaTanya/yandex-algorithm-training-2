import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            Tree tree = new Tree();
            String str = scan.next();
            tree.add(str);
            tree.traverse();
        }

    }
}
class Node {
    private Node parent;
    private Node leftChild; // Левый узел потомок
    private Node rightChild; // Правый узел потомок
    private String type;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
class Tree {
    private Node rootNode; // корневой узел

    public Tree() { // Пустое дерево
        rootNode = new Node();
        rootNode.setType("root");
    }

    public void add (String str) {
        Node currentNode = rootNode;
        while (str.length()!=0){
            switch (str.charAt(0)) {
                case 'D':{
                    Node newNode = new Node();
                    newNode.setParent(currentNode);
                    newNode.setType("left");
                    currentNode.setLeftChild(newNode);
                    currentNode = newNode;
                    break;
                    }
                case  'U':{
                    while (currentNode.getType() == "right" ){
                        currentNode = currentNode.getParent();
                    }
                    currentNode = currentNode.getParent();
                    Node newNode = new Node();
                    newNode.setParent(currentNode);
                    newNode.setType("right");
                    currentNode.setRightChild(newNode);
                    currentNode = newNode;
                    break;
                }
                default:break;
            }
            if (str.length()>1) {
                str = str.substring(1);
            }else {
                break;
            }
        }
    }

    public void traverse(){
        Node currentNode = rootNode;
        String prefix = "";
        ArrayList<String> ans = trave(currentNode,prefix);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    private ArrayList<String> trave(Node currentNode,String prefix){
        ArrayList<String> ans = new ArrayList<String>();
        
        if (currentNode.getLeftChild()!=null){
            ans.addAll(trave(currentNode.getLeftChild(),prefix + "0"));
        }

        if (currentNode.getRightChild() != null) {
            ans.addAll(trave(currentNode.getRightChild(),prefix + "1"));
        }

        if (currentNode.getLeftChild()==null && currentNode.getRightChild() == null){
            ans.add(prefix);
        }
        return ans;
    }
}
