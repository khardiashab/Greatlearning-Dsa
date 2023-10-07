package problem1;

import java.util.ArrayList;

public class MergeSort {
    /**
     * Sorts the given ArrayList using Merge Sort algorithm.
     *
     * @param arr  The ArrayList to be sorted
     * @param low  The starting index of the subarray to be sorted
     * @param high The ending index of the subarray to be sorted
     */
    public void sort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int middleIndex = (low + high) / 2;
            sort(arr, low, middleIndex);
            sort(arr, middleIndex + 1, high);
            merge(arr, low, middleIndex, high);
        }
    }

    /**
     * Merges two subarrays of the given ArrayList.
     *
     * @param arr  The ArrayList to be merged
     * @param low  The starting index of the first subarray
     * @param mid  The ending index of the first subarray
     * @param high The ending index of the second subarray
     */
    private void merge(ArrayList<Integer> arr, int low, int mid, int high) {
        int leftLength = mid - low + 1;
        int rightLength = high - mid;
        ArrayList<Integer> leftList = new ArrayList<>(leftLength);
        ArrayList<Integer> rightList = new ArrayList<>(rightLength);

        // Copy elements from arr to leftList
        for (int i = 0; i < leftLength; i++) {
            leftList.add(arr.get(low + i));
        }

        // Copy elements from arr to rightList
        for (int i = 0; i < rightLength; i++) {
            rightList.add(arr.get(mid + 1 + i));
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = low;

        // Merge the leftList and rightList into arr
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (leftList.get(leftIndex) <= rightList.get(rightIndex)) {
                arr.set(mergeIndex, leftList.get(leftIndex));
                leftIndex++;
            } else {
                arr.set(mergeIndex, rightList.get(rightIndex));
                rightIndex++;
            }
            mergeIndex++;
        }

        // Copy remaining elements from leftList to arr
        while (leftIndex < leftLength) {
            arr.set(mergeIndex, leftList.get(leftIndex));
            leftIndex++;
            mergeIndex++;
        }

        // Copy remaining elements from rightList to arr
        while (rightIndex < rightLength) {
            arr.set(mergeIndex, rightList.get(rightIndex));
            rightIndex++;
            mergeIndex++;
        }
    }
}