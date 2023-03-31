package arvore;


//A classe Node é criada para representar os nós da árvore AVL. A instância da classe Node é criada para criar os nós da árvore AVL.

public class Node {
    int key, height;

    Node left, right;

    public Node(int key) {
        this.key = key;
    }

    public void Node(int d) {
        key = d;
        height = 1;
    }

    public Node(int key, int height, Node left, Node right) {
        this.key = key;
        this.height = height;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
