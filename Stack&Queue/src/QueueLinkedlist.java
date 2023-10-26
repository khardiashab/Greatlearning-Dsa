public class QueueLinkedlist {
    private int size;
    private Node front;
    private Node tail;

    QueueLinkedlist( ){
        size = 0;
        front = null;
        tail = null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node insertNode(int key){
        if(front == null) {
            Node node = new Node(key);
            front = node;
            tail = node;
        } else {
            Node node = new Node(key, null, tail);
            node.getnext().setprev(node);
            tail = node;
        }
        size ++;
        return front;
    }

    public int dequeue(){
        int data = (Integer)null;
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        if(size == 1){
             data = front.getKey();
             front = null;
             tail = null;
        }
        else {
            Node tempNode = front.getprev();
            front = null;
            front = tempNode;
        }
        size--;

        return data;
    }

}
