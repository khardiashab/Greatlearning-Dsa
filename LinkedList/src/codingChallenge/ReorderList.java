package codingChallenge;
import java.util.*;

public class ReorderList {
  private class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  static Node head;

  public void reorderList() {



    // Write your code here
    Node curr;
    curr = head;
    while (curr != null && curr.next != null) {
      Node last = curr;
      Node prev = null;
      while(last.next != null){
        prev = last;
        last = last.next;
      }

      prev.next = null;

      Node next = curr.next;
      curr.next = last;
      last.next = next;
      curr = next;
    }

    // or we can do this 
    Node temp = head;
    while(temp != null && temp.next != null){
      temp.next = reverse(temp.next);
      temp = temp.next;
    }

  }

  public Node reverse(Node head) {
    Node curr = head, prev = null, nex = null;
    while (curr != null) {
      nex = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nex;
    }
    return prev;
  }

  void insert(int value) {
    Node newNode = new Node(value);

    if (head == null) {
      head = newNode;
      return;
    }

    newNode.next = null;

    Node tmp = head;
    while (tmp.next != null)
      tmp = tmp.next;

    tmp.next = newNode;
    return;
  }

  void display() {
    Node tmp = head;
    while (tmp != null) {
      System.out.println(tmp.data);
      tmp = tmp.next;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    ReorderList ob = new ReorderList();
    int numberOfNodes = in.nextInt();
    while (numberOfNodes-- > 0)
      ob.insert(in.nextInt());
    ob.reorderList();
    ob.display();

  }

}
