package problem2.driver;

import problem2.model.Node;
import problem2.service.LowestCommonAncestor;

public class Main {

    public static void main(String[] args) {
        final Node root = new Node(10);
        root.setLeft(new Node(20));
        root.setRight(new Node(30));
        root.getLeft().setLeft(new Node(40));
        root.getLeft().setRight(new Node(50));
        root.getRight().setLeft(new Node(60));
        root.getRight().setRight(new Node(70));
        int node1 = 70;
        int node2 = 50;

        int lowestCommonAncestor = LowestCommonAncestor.getLowestCommonAncestor(root, node1, node2);
        if(lowestCommonAncestor != -1) System.out.println("Lowest common Ancestor ["+ node1 + ", "+ node2 + "] : " + lowestCommonAncestor);

    }

}
