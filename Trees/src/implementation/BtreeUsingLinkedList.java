package implementation;

import java.util.LinkedList;

public class BtreeUsingLinkedList {

    private class Node {

        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    Node root;
    LinkedList<Node> leafNodeQueue;

    BtreeUsingLinkedList() {
        root = null;
        leafNodeQueue = new LinkedList<>();
    }

    public Node insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            leafNodeQueue.addLast(root);
            return root = node;
        }
        Node leaf = leafNodeQueue.removeFirst();
        if (leaf.left == null) {
            leaf.left = node;
            leafNodeQueue.addFirst(leaf);
        } else {
            leaf.right = node;
        }
        leafNodeQueue.addLast(node);
        return node;
    }

    public void inOrdertraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrdertraversal(root.left);
        System.out.print(root.data + " ");
        inOrdertraversal(root.right);
    }

    public void preOrdertraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrdertraversal(root.left);
        preOrdertraversal(root.right);
    }

    public void postOrdertraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrdertraversal(root.left);
        postOrdertraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void leverOrdertraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            if (node.left != null) {
                queue.addLast(node.left);
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            System.out.print(node.data + " ");
        }
    }

    public void delete(int val) {
        if (root == null)
            return;
        if (root.data == val) {
            Node lastNode = leafNodeQueue.removeLast();
            if (root.equals(lastNode))
                root = null;
            lastNode.left = root.left;
            lastNode.right = root.right;
            root = lastNode;
        }

        LinkedList<Node> queue = new LinkedList<>();

        Node lastNode = leafNodeQueue.removeLast();
    }

    public static void main(String[] args) {
    }
}
