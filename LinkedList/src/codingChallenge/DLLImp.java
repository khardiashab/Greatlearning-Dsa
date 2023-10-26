package codingChallenge;

import java.util.*;

public class DLLImp {
    Nod head;
    Nod tail;

    DLLImp() {
        head = null;
        tail = null;
    }

    void insert(int val) {
        Nod node = new Nod(val);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    void traverse() {
        if (head == null) {
            return;
        }
        Nod temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseTraverse() {
        if (tail == null) {
            return;
        }
        Nod temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        DLLImp dllImp = new DLLImp();
        while (size-- > 0) {
            dllImp.insert(sc.nextInt());
        }
        dllImp.traverse();
        dllImp.reverseTraverse();
    }
}

class Nod {
    int data;
    Nod next, prev;

    Nod(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
