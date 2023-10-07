import java.util.ArrayList;
import java.util.Scanner;

/**
 * Question1
 * In a stable, there are N horses, with different speeds, None of the two
 * horses has the same speed.
 * The speed of the horse i is represented by S[i]. Find the two horses from the
 * group such that the difference between their speeds is minimum, print the
 * difference as output.
 * 
 * Time Complexity Restraint = O(nlogn)
 * 
 * Sample input
 * 
 * N=5
 * S[]= { 4,9,32,1,18,13}
 * 
 * Sample Output
 * The minimum difference between the speeds of various horses is 3 {4-1}
 */
public class HorseSpeedProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many horses in the stable: ");
        final int N = sc.nextInt();
        int[] S = new int[N];
        ArrayList<Integer> arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());

        }

        arr.sort(null);
        System.out.println(arr);
        int minimum = arr.get(N - 1) - arr.get(0);
        int index = 0;

        for (int i = 0; i < N - 1; i++) {
            int diff = arr.get(i + 1) - arr.get(i);
            if (diff < minimum) {
                minimum = diff;
                index = i;
            }
        }
        System.out.println(String.format("The minimum difference between the speeds of various horses is %d {%d-%d}",
                minimum, arr.get(index + 1), arr.get(index)));

        sc.close();
    }

}