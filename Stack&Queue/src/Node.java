
public class Node {
    private int key;
    private Node prev;
    private Node next;

    Node(int data){
        this.key = data;
        prev = null;
        next = null;
    }

    Node( int data, Node prevNode, Node nextNode)
    {
        key = data;
        prev = prevNode;
        next = nextNode;
    }
    //

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getprev() {
        return prev;
    }

    public void setprev(Node prev) {
        this.prev = prev;
    }

    public Node getnext() {
        return next;
    }

    public void setnext(Node next) {
        this.next = next;
    }
}
