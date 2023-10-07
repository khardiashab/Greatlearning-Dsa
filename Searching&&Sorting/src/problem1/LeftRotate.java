package problem1;

import java.util.ArrayList;

public class LeftRotate {
    /**
     * This method rotates the array by swapping elements.
     * @param array The array to be rotated
     * @param rotationPoint The index to rotate until
     */
    public void rotateLeft(ArrayList<Integer> array, int rotationPoint) {
        for (int i = 0; i <= rotationPoint; i++) {
            swapElementsWithNext(array);
        }
    }

    /**
     * This method swaps every element with the next element in the array.
     * 
     * @param array The array to swap elements in
     */
    private void swapElementsWithNext(ArrayList<Integer> array) {
        int size = array.size();
        int temp = array.get(0);
        for (int i = 0; i < size - 1; i++) {
            array.set(i, array.get(i + 1));
        }
        array.set(size - 1, temp);
    }

    /**
     * This method rotates the array in three steps:
     * 1. Reverse the whole array.
     * 2. Reverse the left part of the array until the rotation point (included).
     * 3. Reverse the right (rest) part of the array.
     * 
     * @param array The array to be rotated
     * @param rotationPoint The index to rotate until
     */
    public void rotateLeftThreeSteps(ArrayList<Integer> array, int rotationPoint) {
        int size = array.size();
        reverseArray(array, 0, size - 1);
        reverseArray(array, 0, rotationPoint);
        reverseArray(array, rotationPoint + 1, size - 1);
    }

    /**
     * This method reverses the elements in the array from start to end.
     * 
     * @param array The array to reverse elements in
     * @param start The starting index
     * @param end The ending index
     */
    public void reverseArray(ArrayList<Integer> array, int start, int end) {
        while (start < end) {
            int temp = array.get(end);
            array.set(end, array.get(start));
            array.set(start, temp);
            start++;
            end--;
        }
    }

    public void methodTwo(ArrayList<Integer> array, int mid) {
    }
}