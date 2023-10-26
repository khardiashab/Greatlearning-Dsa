package implementation;

public class Avl {
    private class Node {
        int key;
        int height;
        Node left, right;

        Node(int value) {
            key = value;
            height = 1;
            left = null;
            right = null;
        }

    }

    int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);
        if (node.key > node.key)
            node.right = insert(node.right, value);
        else if (node.key < node.key)
            node.left = insert(node.left, value);
        else
            return node;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalanceFactor(node);

        // condition for Left Rotation(R R rotation or right skewed)
        if(balance < -1  && value > node.right.key){
            return leftRotation(node);
        }
        // condition for Right Rotation(LL rotation or left skewed rotation)
        if( balance > 1 && value < node.left.key){
            return rightRotation(node);
        }


        return node;
    }

    /**
     *                      x                           y
     *                    /                           /   \
     *                  y           =>               z      x
     *                 /  \                                /
     *                z     T                             T
     * @param x
     * @return
     */

    private Node rightRotation(Node x) {
        Node y = x.left;
        Node T = y.right;

        // performing rotation
        x.left = T;
        y.right = x;
        return y;
    }

    /**
     *              x                               y
     *                \                             
     *                  y       =>         
     *                /   \
     *               t     z
     * @param node
     * @return
     */
    private Node leftRotation(Node node) {
        return null;
    }
}
