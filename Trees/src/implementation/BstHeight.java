package implementation;

public class BstHeight {
    static class Node {

        int key;

        Node left, right;
    }

    static Node newNode(int val) {
        Node node = new Node();
        node.key = val;
        node.right = null;
        node.left = null;
        return node;
    }

    Node insertNode(Node root, int value) {

        Node node = newNode(value);
        if (root == null) {
            return node;
        }
        Node temp = root;
        while (temp != null) {
            if (temp.key > value) {
                if (temp.left == null) {
                    temp.left = node;
                    return node;
                }

                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    return node;
                }
                temp = temp.right;
            }
        }
        return root;
    }

    int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BstHeight bst = new BstHeight();
        Node root = null;
        root = bst.insertNode(root, 67);
        bst.insertNode(root, 55);
        bst.insertNode(root, 76);
        bst.insertNode(root, 89);
        bst.insertNode(root, -21);
        bst.insertNode(root, 12);
        bst.insertNode(root, -20);
        bst.insertNode(root, 38);
        bst.insertNode(root, 75);
        System.out.println(bst.heightOfTree(root));
    }
}
