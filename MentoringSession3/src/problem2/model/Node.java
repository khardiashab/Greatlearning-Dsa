package problem2.model;

public class Node {
    private int data;
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    private Node left, right;

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

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}
