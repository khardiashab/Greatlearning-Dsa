package implementation;

import java.lang.RuntimeException;

class Node {
    int data;
    Node nextNode;
    Node previousNode;

    Node(int data) 
    {
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
    }

    public Node(int data, Node prevNode, Node nextNode) {
        this.data = data;
        this.previousNode = prevNode;
        this.nextNode = nextNode;
    }
}

public class DoublyLinkedList {
    private Node headNode;
    private Node lastNode;
    private int size;

    DoublyLinkedList() {
        headNode = null;
        lastNode = null;
        size = 0;
    }

    public void addAtFirst(int data) {
        if (size == 0) {
            Node node = new Node(data);
            headNode = node;
            lastNode = node;
            size++;
        } else {
            Node currentNode = headNode;
            headNode = new Node(data, null, currentNode);
            currentNode.previousNode = headNode;
            size++;
        }
    }

    public void addAtEnd(int data) {
        if (size == 0) {
            Node node = new Node(data);
            headNode = node;
            lastNode = node;
        } else {

            Node node = new Node(data, lastNode, null);
            lastNode = node;
        }
        size++;

    }

    public void addItemAtPos(int index, int value) {
        if (index >= size) {
            throw new RuntimeException("Index out of bond");
        }
        if (index == 0) {
            addAtFirst(value);

        } else if (index == size - 1)
            addAtEnd(value);
        else {
            int currentIndex = 0;
            Node currentNode = headNode;
            while (currentIndex++ < index - 1) {
                currentNode = currentNode.nextNode;
            }
            Node node = new Node(value, currentNode.previousNode, currentNode);
            currentNode.previousNode.nextNode = node;
            size++;

        }
    }

    public void removeAtFirst() {
        // if list is empty
        if (size == 0)
            throw new RuntimeException("list is empty.");
        // if size = 1 then
        else if (size == 1) {
            headNode = null;
            lastNode = null;
            size = 0;

        }
        // if size is > 1;
        else {
            headNode = headNode.nextNode;
            headNode.previousNode = null;
            size--;
        }

    }

    public void removeAtEnd() {
        // if item is at the end
        if (size == 0) {
            throw new RuntimeException("list is empty");
        } else if (size == 1) {
            headNode = null;
            lastNode = null;
            size--;
        } else {
            lastNode = lastNode.previousNode;
            lastNode.nextNode = null;
            size--;
        }
    }

    public void removeAtIndex(int index) {
        if (index >= size) {
            throw new RuntimeException("Index out of bond.");

        }
        if (index == 0) {
            removeAtFirst();
            return;
        } else if (index == size - 1) {
            removeAtEnd();
            return;
        } else {
            int currentIndex = 0;
            Node currentNode = headNode;

            while (currentIndex++ < index) {
                currentNode = currentNode.nextNode;
            }
            currentNode.previousNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.previousNode = currentNode.previousNode;
            size--;

        }

    }

    public int search(int value){
        // traverse in linked list 
        int currentIndex = 0;
        Node currentNode = headNode;
        while (currentNode != null) {
            if(currentNode.data == value) return currentIndex;
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        return -1;
    }

    public void display(){
        System.out.println("Doubly linked list : ");
        Node currentNode = headNode;
        while (currentNode !=null) {
            System.out.println(currentNode.data + "-> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println(" null");
    }
    
    public void displayReverse(){
        System.out.println("Doubly linked list : ");
        Node currentNode = lastNode;
        while (currentNode !=null) {
            System.out.println(currentNode.data + "-> ");
            currentNode = currentNode.previousNode;
        }
        System.out.println(" null");  
    }

    public static void main(String[] args) {
        DoublyLinkedList cll = new DoublyLinkedList();
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
}