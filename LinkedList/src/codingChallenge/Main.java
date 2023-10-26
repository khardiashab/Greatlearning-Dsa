package codingChallenge;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i< size; i++){
            int input = sc.nextInt();
           if( linkedList.isEmpty()){
            linkedList.addLast(input);
           } else {
            if(input == linkedList.pop()){
                linkedList.removeLast();
            } else {
                linkedList.addLast(input);
            }
           }
        }
        System.out.println(linkedList.size());
        // System.out.println(linkedList);

    }
}
