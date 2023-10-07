package implementation;

import java.lang.RuntimeException;

/**
 * Stack implementation with various operations.
 * 1. push(): Inserting an item into the stack.
 * 2. pop(): Deleting an item from the stack.
 * 3. isFull(): Check if the stack is full or not.
 * 4. isEmpty(): Check if the stack is empty or not.
 * 5. display(): Display the items of the stack.
 * 6. peek(): View the element at the top of the stack without removing it.
 * 7. search(e): Search if an element e is present in the stack.
 * 8. getMin(): Get the minimum value from the stack (if the stack type is int).
 */
public class Stack<T> {
    private int top = -1; // Represents the top index of the stack
    private int size; // Represents the size of the stack
    private T[] arr; // Represents the array to store stack elements

    /**
     * Default constructor.
     * Initializes the stack with a default size of 10.
     */
    public Stack() {
        this.size = 10;
        arr = (T[]) new Object[10];
    }

    /**
     * Parameterized constructor.
     * Initializes the stack with the given size.
     *
     * @param size The size of the stack
     */
    public Stack(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
    }

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param item The item to be pushed onto the stack
     * @throws RuntimeException if the stack is full
     */
    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Error: Stack is full.");
        }
        arr[++top] = item;
    }

    /**
     * Pops and returns the item from the top of the stack.
     *
     * @return The popped item
     * @throws RuntimeException if the stack is empty
     */
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Exception: Stack is empty");
        return arr[top--];
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack
     */
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");
        return arr[top];
    }

    /**
     * Displays the elements of the stack.
     */
    public void display() {
        System.out.print("Stack: [ ");
        for (int i = 0; i <= top; i++) {
            System.out.print(String.format("%d ", arr[i]));
        }
        System.out.println("]");
    }

    /**
     * Searches for an element in the stack.
     *
     * @param e The element to search for
     * @return The index of the element if found, -1 otherwise
     */
    public int search(T e) {
        for (int i = 0; i <= top; i++) {
            if (arr[i] == e)
                return i;
        }
        return -1;
    }

    /**
     * Get the minimum value from the stack (if the stack type is int).
     *
     * @return The minimum value in the stack
     * @throws RuntimeException if the stack type is not int
     */
    public Integer getMin() {
        if (isEmpty()) {
            throw new RuntimeException("Exception: Stack is empty.");
        }
        if (arr[0] instanceof Integer) {
            int min = (int)arr[0];
            for (int i = 1; i <= top; i++) {
                min = Math.min((int)min, (int)arr[i]);
            }
            return min;
        } else {
            throw new RuntimeException("Error: Stack type is not int.");
        }
    }
}