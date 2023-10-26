package codingChallenge;

import java.util.*;

public class Median {

    static public int[] solve(int[] A, int n) {
        int[] ans = new int[A.length];
        LinkedList <Integer> ll = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            ll.add(A[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        int[] ans = solve(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(ans[i] + " ");

    }
}
