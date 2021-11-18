import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Tree tree = new Tree();
        while (scan.hasNext()){
            String[] s = scan.nextLine().split(" ");

            switch (s[0]){
                case "ADD": {
                    tree.add(Integer.parseInt(s[1]));
                    break;
                }
                case "SEARCH": {
                    tree.search(Integer.parseInt(s[1]));
                    break;
                }
                case "PRINTTREE": {
                    tree.printTree();
                    break;
                }
                default: break;
            }
        }
    }
}

class Node {
    private int value; // ключ узла
    private Node leftChild; // Левый узел потомок
    private Node rightChild; // Правый узел потомок

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
}

class Tree {
    private Node rootNode; // корневой узел

    public Tree() { // Пустое дерево
        rootNode = null;
    }

    public void add (int value){
        Node newNode = new Node();
        newNode.setValue(value);
        if (rootNode == null){

            System.out.println("DONE");

            rootNode = newNode;
        } else {
            Node currentNode = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {   // если такой элемент в дереве уже есть, не сохраняем его

                    System.out.println("ALREADY");

                    return;    // просто выходим из метода
                } else if (value < currentNode.getValue()) {   // движение влево?
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) { // если был достигнут конец цепочки,

                        System.out.println("DONE");

                        parentNode.setLeftChild(newNode); //  то вставить слева и выйти из методы
                        return;
                    }
                } else { // Или направо?
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) { // если был достигнут конец цепочки,

                        System.out.println("DONE");

                        parentNode.setRightChild(newNode);  //то вставить справа
                        return; // и выйти
                    }
                }
            }
        }

    }

    public void search (int value) {
        if (rootNode != null) {
            Node currentNode = rootNode; // начинаем поиск с корневого узла

            while (currentNode.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
                if (value < currentNode.getValue()) { // движение влево?
                    currentNode = currentNode.getLeftChild();
                } else { //движение вправо
                    currentNode = currentNode.getRightChild();
                }
                if (currentNode == null) { // если потомка нет,
                    System.out.println("NO");
                    return; // возвращаем null
                }
            }
            if (currentNode != null) {
                System.out.println("YES");
            }
        } else {
            System.out.println("NO");
        }
    }


    public void printTree (){
        Node currentNode = rootNode;
        int t = 0;
        print(currentNode, t);
    }

    private void print (Node currentNode, int t) {

        if (currentNode.getLeftChild() != null) {
            print(currentNode.getLeftChild(), t+1);
        }
        for (int i = 0; i < t; i++) {
            System.out.print(".");
        }
        System.out.println(currentNode.getValue());

        if (currentNode.getRightChild() != null) {
            print(currentNode.getRightChild(), t+1);
        }
        //return;

    }
}
