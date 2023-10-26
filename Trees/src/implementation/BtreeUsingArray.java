package implementation;

import java.util.*;

public class BtreeUsingArray {
    int[] arr; 
    int len;
    
    // we have create a complete binary tree from starting at index 1
    BtreeUsingArray(int size){
        arr = new int[size+1];
        arr[0] = size +1;
        len = 1;
    }

    public void insert(int val){
        if(len >= arr[0]) throw new RuntimeException("height is full.");
        arr[len++] = val;
    }

    public void delete(int val){
        for (int i = 1; i < len; i++) {
            if(arr[i] == val){
                arr[i] = arr[len-1];
                len--;
                arr[len] = val;
            }
        }
    }

    public void leverOrdertraversal(){
        for (int i = 1; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void inorderTraversal(int index){
        if(index >= len){
            return;
        }
        int leftChildIndex = index * 2;
        int rightChildIndex = index * 2 + 1;
        inorderTraversal(leftChildIndex);
        System.out.print(arr[index] + " ");
        inorderTraversal(rightChildIndex);
    }

    public void preorderTraversal(int index){
        if(index >= len){
            return;
        }
        int leftChildIndex = index * 2;
        int rightChildIndex = index * 2 + 1;
        System.out.print(arr[index] + " ");
        preorderTraversal(leftChildIndex);
        preorderTraversal(rightChildIndex);
    }

    public void postorderTraversal(int index){
        if(index >= len){
            return;
        }
        int leftChildIndex = index * 2;
        int rightChildIndex = index * 2 + 1;
        postorderTraversal(leftChildIndex);
        postorderTraversal(rightChildIndex);
        System.out.print(arr[index] + " ");
    }

    public static void main(String[] args) {
        BtreeUsingArray bt = new BtreeUsingArray(10);
            // Insert elements
    bt.insert(5);
    bt.insert(3);
    bt.insert(7);
    bt.insert(2);
    bt.insert(4);
    bt.insert(6);
    bt.insert(8);
    
    // Perform traversals
    System.out.println("Level Order Traversal:");
    bt.leverOrdertraversal();
    
    System.out.println("Inorder Traversal:");
    bt.inorderTraversal(1);
    System.out.println();
    
    System.out.println("Preorder Traversal:");
    bt.preorderTraversal(1);
    System.out.println();
    
    System.out.println("Postorder Traversal:");
    bt.postorderTraversal(1);
    System.out.println();
    
    // Delete an element
    bt.delete(4);
    
    // Perform traversals after deletion
    System.out.println("Level Order Traversal after deletion:");
    bt.leverOrdertraversal();
    
    System.out.println("Inorder Traversal after deletion:");
    bt.inorderTraversal(1);
    System.out.println();
    
    System.out.println("Preorder Traversal after deletion:");
    bt.preorderTraversal(1);
    System.out.println();
    
    System.out.println("Postorder Traversal after deletion:");
    bt.postorderTraversal(1);
    System.out.println();
    }
    
}
