package implementation;

/**
 * Node class for representing a node in a singly linked list.
 */
class Node {
    Integer data;
    Node nextNode;

    Node() {
        data = null;
        nextNode = null;
    }

    Node(int data) {
        this.data = data;
        nextNode = null;
    }

    Node(int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
}

/**
 * Class for implementing a singly linked list.
 */
public class SinglyLinkedList {
    private Node headNode;

    SinglyLinkedList() {
        headNode = null;
        System.out.println(headNode);
    }

    SinglyLinkedList(Node node) {
        headNode = node;
    }

    /**
     * Adds a node at the beginning of the linked list.
     *
     * @param item The data to be added to the new node.
     * @return The head node of the linked list.
     */
    public Node addAtFirst(int item) {
        Node newNode = new Node(item, headNode);
        headNode = newNode;
        return headNode;
    }

    /**
     * Removes the first node from the linked list.
     *
     * @return The data of the removed node.
     * @throws RuntimeException if the list is empty.
     */
    public int removeAtFirst() {
        if (headNode == null)
            throw new RuntimeException("Empty list");
        int item = headNode.data;
        headNode = headNode.nextNode;
        return item;
    }

    /**
     * Removes the last node from the linked list.
     *
     * @return The data of the removed node.
     * @throws RuntimeException if the list is empty.
     */
    public int removeAtEnd() {
        if (headNode == null)
            throw new RuntimeException("Empty list");
        int item;
        Node previousNode = null;
        Node currentNode = headNode;
        while (currentNode.nextNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        item = currentNode.data;
        if (previousNode != null)
            previousNode.nextNode = null;
        else
            headNode = null;
        return item;
    }

    /**
     * Removes the node at the given index from the linked list.
     *
     * @param index The index of the node to be removed.
     * @throws RuntimeException if the index is out of bounds.
     */
    public void removeAtIndex(int index) {
        if (headNode == null || index < 0)
            throw new RuntimeException("Invalid index");
        if (index == 0) {
            headNode = headNode.nextNode;
            return;
        }
        int currentIndex = 0;
        Node previousNode = null;
        Node currentNode = headNode;
        while (currentIndex < index) {
            if (currentNode == null)
                throw new RuntimeException("Invalid index");
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        if (currentNode != null)
            previousNode.nextNode = currentNode.nextNode;
    }

    /**
     * Removes the node with the given value from the linked list.
     *
     * @param value The value of the node to be removed.
     */
    public void removeByValue(int value) {
        if (headNode == null)
            return;
        if (headNode.data == value) {
            headNode = headNode.nextNode;
            return;
        }
        Node previousNode = null;
        Node currentNode = headNode;
        while (currentNode != null && currentNode.data != value) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (currentNode != null)
            previousNode.nextNode = currentNode.nextNode;
    }

    /**
     * Adds a node at the end of the linked list.
     *
     * @param item The data to be added to the new node.
     * @return The head node of the linked list.
     */
    public Node addAtEnd(int item) {
        Node node = new Node(item);
        if (headNode == null) {
            headNode = node;
        } else {
            Node currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }
        return headNode;
    }

    /**
     * Adds a node at the given position in the linked list.
     *
     * @param index The position at which the node should be added.
     * @param item  The data to be added to the new node.
     * @return The head node of the linked list.
     * @throws RuntimeException if the index is out of bounds.
     */
    public Node addItemAtPos(int index, int item) {
        if (index < 0)
            throw new RuntimeException("Invalid index");
        Node node = new Node(item);
        if (index == 0) {
            node.nextNode = headNode;
            headNode = node;
            return headNode;
        }
        int currentIndex = 0;
        Node currentNode = headNode;
        while (currentIndex < index - 1 && currentNode != null) {
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        if (currentNode == null)
            throw new RuntimeException("Invalid index");
        node.nextNode = currentNode.nextNode;
        currentNode.nextNode = node;
        return headNode;
    }

    /**
     * Searches for the given item in the linked list.
     *
     * @param item The item to search for.
     * @return The index of the item if found, -1 otherwise.
     */
    public int search(int item) {
        Node currentNode = headNode;
        int currentIndex = 0;
        while (currentNode != null) {
            if (currentNode.data == item) {
                return currentIndex;
            }
            currentNode = currentNode.nextNode;
            currentIndex++;
        }
        return -1;
    }

    /**
     * Displays the linked list.
     */
    public void display() {
        Node currentNode = headNode;
        System.out.print("List: [head : ");
        while (currentNode != null) {
            System.out.print(currentNode.data + "-> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("null]");
    }

    public static void main(String[] args) {
        try {
            SinglyLinkedList linkedList = new SinglyLinkedList();
            linkedList.addAtEnd(5);
            linkedList.addAtFirst(15);
            linkedList.addAtFirst(43);
            linkedList.addAtFirst(45);
            linkedList.addItemAtPos(2, 44);
            linkedList.addItemAtPos(5, 20);
            System.out.println("search 45: " + linkedList.search(45));
            System.out.println("search 20: " + linkedList.search(20));
            System.out.println("search 15: " + linkedList.search(15));
            System.out.println("search 14: " + linkedList.search(14));
            linkedList.addAtEnd(0);
            linkedList.display();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}