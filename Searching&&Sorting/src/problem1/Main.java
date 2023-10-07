package problem1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        final int N = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<>(N);
        System.out.println("Enter the values: ");
        for (int i = 0; i < N; i++) {
            array.add(sc.nextInt());
        }

        System.out.println(array);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, N-1);
        System.out.println(array);
        
        LeftRotate leftRotate = new LeftRotate();

        int mid = (N-1)/2;

        leftRotate.methodTwo(array, mid);

        System.out.println(array);
    }
}
