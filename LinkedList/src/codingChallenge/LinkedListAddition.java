package codingChallenge;

import java.util.*;

class LinkedListAddition {

    Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Node prev = null, next = null;

        while(temp.next != null ){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        temp.next = prev;
        head = temp;

        return head;
    }

  void addTwolsts(Node first, Node second) {
      //write your code here
      Node one = reverse(first);
      Node two = reverse(second);
      Node result = null;
      int reminder = 0, quotient = 0, sum = 0;

      while(one != null && two != null){
        sum = one.data + two.data + quotient;
        reminder = sum % 10 ;
        quotient = sum / 10;
        result = insert(result, reminder);
        one = one.next;
        two = two.next;
      }
      while(one != null){
        sum = one.data + quotient;
        reminder = sum % 10 ;
        quotient = sum / 10;
        result = insert(result, reminder);
        one = one.next;
      }
      while(two != null){
        sum = two.data + quotient;
        reminder = sum % 10 ;
        quotient = sum / 10;
        result = insert(result, reminder);
        two = two.next;
      }

      result = reverse(result);
      printlst(result);
  }

  void printlst(Node head) {
    while (head != null) {
      System.out.print(head.data);
      head = head.next;
    }
  }

  Node insert(Node head, int item) {
    Node tmp = new Node(item);
    if (head == null) {
      head = tmp;
      return head;
    }

    Node tmp1 = head;
    while (tmp1.next != null)
      tmp1 = tmp1.next;
    tmp1.next = tmp;
    return head;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Node head1 = null, head2 = null;
    int n1 = in .nextInt();
    int n2 = in .nextInt();
    LinkedListAddition lst1 = new LinkedListAddition();
    LinkedListAddition lst2 = new LinkedListAddition();

    while (n1--> 0)
      head1 = lst1.insert(head1, in .nextInt());

    while (n2--> 0)
      head2 = lst2.insert(head2, in .nextInt());

    lst1.addTwolsts(head1, head2);
  }

}

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}