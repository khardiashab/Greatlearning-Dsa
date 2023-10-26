package codingChallenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

class count_pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        Integer arr1[] = new Integer[n1];

        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        Integer arr2[] = new Integer[n2];

        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();

        LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
        LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));

        int k = sc.nextInt();
        Solution Code = new Solution();
        System.out.println(Code.countPairs(head1, head2, k));
    }

}

class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
            int k) {
        // add your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(Integer num : head2) {
            Integer value = hm.getOrDefault(num, 0);

            hm.put(num, value + 1);
        }
        int count = 0;
        for(Integer num : head1) {
            count += hm.getOrDefault(k-num, 0);
        }
        return count;
    }

}

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
