package implementation;

import java.lang.RuntimeException;

class Node {
    int data;
    Node nextNode;

    Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    Node(int data, Node node) {
        this.data = data;
        this.nextNode = node;
    }
}

public class CricularLinkedList {
    private Node headNode;

    CricularLinkedList() {
        headNode = null;
    }

    public void addAtFirst(int data) {
        Node node = new Node(data);
        if (headNode == null) {
            headNode = node;
            headNode.nextNode = node;
            return;
        }
        Node currentNode = headNode;
        while (currentNode.nextNode != headNode) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = node;
        node.nextNode = headNode;
        headNode = node;
    }

    public void addAtEnd(int data) {
        if(headNode == null){
           headNode = new Node(data);
           headNode.nextNode = headNode;
           return;
        }
        Node node = new Node(data, headNode);
        Node currentNode = headNode;
        while (currentNode.nextNode != headNode)
            currentNode = currentNode.nextNode;
        currentNode.nextNode = node;
    }

    public void addItemAtPos(int index, int data) {
        if (index == 0) {
            addAtFirst(data);
            return;
        }
        Node currentNode = headNode;
        int currentIndex = 0;
        while (currentNode.nextNode != headNode && currentIndex < index -1) {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        // add item at the end
        if (currentNode.nextNode == headNode && currentIndex == index) {
            Node node = new Node(data, headNode);
            currentNode.nextNode = node;
            return;
        }
        // if index in between
        System.out.println(" current node data : " + currentNode.data);
        Node node = new Node(data, currentNode.nextNode);
        currentNode.nextNode = node;
        return;
    }

    public void removeAtFirst() {
        if (headNode == null)
            throw new RuntimeException("Linked list is null");
        Node currentNode = headNode;
        while (currentNode.nextNode != headNode) {
            currentNode = currentNode.nextNode;
        }
        headNode = headNode.nextNode;
        currentNode.nextNode = headNode;

    }

    public void removeAtEnd() {
        if (headNode == null)
            throw new RuntimeException("Linked list is null");
        if (headNode.nextNode == headNode)
            headNode = null;
        else {
            Node previousNode = null;
            Node currNode = headNode;
            while (currNode.nextNode != headNode) {
                previousNode = currNode;
                currNode = currNode.nextNode;
            }
            previousNode.nextNode = headNode;
            return;
        }

    }

    public void removeByValue(int value) {
        if (headNode == null)
            throw new RuntimeException("Linked list is nnull");
        if (headNode.nextNode == headNode) {
            if (headNode.data == value) {
                headNode = null;
                return;
            } else {

            }
        }
        Node prevNode = null;
        Node currentNode = headNode;
        while (currentNode.data != value) {
            if (prevNode != null && currentNode == headNode)
                throw new RuntimeException("Run time exception.");
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

    }

        /**
     * Displays the linked list.
     */
    public void display() {
        Node currentNode = headNode;
        System.out.print("List: [head : ");
        while (currentNode.nextNode != headNode) {
            System.out.print(currentNode.data + "-> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println(currentNode.data + " : " + "null]");
    }

    public static void main(String[] args) {
        CricularLinkedList cll = new CricularLinkedList();
        try {
            cll.addAtEnd(118);
            cll.addAtFirst(15);
            cll.addAtFirst(43);
            cll.addAtFirst(45);
            cll.addAtEnd(5);
            cll.addItemAtPos(5, 44);
            cll.display();
            cll.addItemAtPos(3, 20);
            // System.out.println("search 45: " + cll.search(45));
            // System.out.println("search 20: " + cll.search(20));
            // System.out.println("search 15: " + cll.search(15));
            // System.out.println("search 14: " + cll.search(14));
            // cll.addAtEnd(0);
            cll.display();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String search(int i) {
        return null;
    }

}
