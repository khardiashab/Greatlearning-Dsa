package questions;

import java.util.Scanner;

import implementation.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Notations objNotations = new Notations();
        Stack<Integer> st = new Stack<>(5);
        try {
            st.push(5);
            st.push(10);
            st.push(1);
            st.push(0);
            st.push(5);
            System.out.println(st.getMin());
            System.out.println("Enter the infix in string: ");
            String infixString = sc.nextLine();
            System.out.print("Postfix:");
            System.out.println(objNotations.infixToPostfixNotation(infixString));
            System.out.print("Prefix: ");
            System.out.println(objNotations.infixToPrefix(infixString));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
         finally {
            if (sc != null)
                sc.close();
        }
    }
}
