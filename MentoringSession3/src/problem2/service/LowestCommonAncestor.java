package problem2.service;

import java.util.LinkedList;
import problem2.model.Node;

/**
 * LowestCommonAncestor class provides methods to find the lowest common
 * ancestor of two nodes in a binary tree.
 */
public class LowestCommonAncestor {

    /**
     * Finds the lowest common ancestor of two nodes in a binary tree.
     *
     * @param root  The root node of the binary tree.
     * @param node1 The value of the first node.
     * @param node2 The value of the second node.
     * @return The lowest common ancestor of node1 and node2.
     */
    public static int getLowestCommonAncestor(Node root, int node1, int node2) {
        LinkedList<Integer> path1 = new LinkedList<>();
        LinkedList<Integer> path2 = new LinkedList<>();

        findPath(root, node1, path1);
        findPath(root, node2, path2);

        int size1 = path1.size();
        int size2 = path2.size();
        int result = -1;

        if (size1 == 0) {
            System.out.println("Node " + node1 + " is not available in the binary tree.");
        }

        if (size2 == 0) {
            System.out.println("Node " + node2 + " is not available in the binary tree.");
        }

        System.out.println("Path for node " + node1 + ": " + path1);
        System.out.println("Path for node " + node2 + ": " + path2);

        int minSize = Math.min(size1, size2);

        for (int i = 0; i < minSize; i++) {
            int ele1 = path1.removeFirst();
            int ele2 = path2.removeFirst();

            if (ele1 != ele2) {
                break;
            } else {
                result = ele1;
            }
        }

        return result;
    }

    /**
     * Finds the path from the root to the given node in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @param node The value of the node to find the path for.
     * @param path The linked list to store the path.
     * @return True if the node is found, False otherwise.
     */
    private static boolean findPath(Node root, int node, LinkedList<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.getData());

        if (root.getData() == node) {
            return true;
        }

        if (findPath(root.getLeft(), node, path) || findPath(root.getRight(), node, path)) {
            return true;
        } else {
            path.removeLast();
            return false;
        }
    }
}