package implementation;

import java.lang.RuntimeException;

public class Queue {
    private int front = -1;
    private int rear = -1;
    private int size = 0;
    private int[] arr;

    Queue() {
        arr = new int[10];
        size = 10;
    }

    Queue(int size) {
        arr = new int[size];
        this.size = size;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            arr[++rear] = item;
            if (front == -1) {
                front++;
            }
        } else {
            throw new RuntimeException("Exception: Queue is full. Size: " + size);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Exception: Queue is empty. Size: " + size);
        }

        int item = arr[front++];
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return item;
    }

    public boolean isFull() {
        return (rear == size - 1);
    }

    public boolean isEmpty() {
        return (front == -1 || front > rear);
    }
}