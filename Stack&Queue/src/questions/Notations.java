package questions;

import java.util.Arrays;
import java.util.HashSet;
import implementation.Stack;

/**
 * Class for converting infix expressions to postfix and prefix notations.
 */
public class Notations {
    private static final HashSet<Character> OPERATORS = new HashSet<>(Arrays.asList('+', '-', '*', '/', '%', '^'));

    /**
     * Converts infix expression to postfix notation.
     *
     * @param infix The infix expression to convert.
     * @return The Postfix/ notation of the infix expression .
     * 
     */
    public String infixToPostfixNotation(String infix) {
        Stack<Character> stack = new Stack<>(infix.length());
        StringBuilder postfix = new StringBuilder();

        // Process the infix expression normally
        for (Character ch : infix.toCharArray()) {
            if (ch == ' ') {
                continue;
            } else if (Character.isLetterOrDigit(ch)) {
                // If the next element is an operand, display it
                postfix.append(ch).append(' ');
            } else if (ch == '(') {
                // Push the next element on the stack if it is an opening bracket
                stack.push(ch);
            } else if (OPERATORS.contains(ch)) {
                // If the next element is an operator
                if (stack.isEmpty() || stack.peek() == '(' || getPrecedence(ch) > getPrecedence(stack.peek())) {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty() && stack.peek() != '('
                            && (getPrecedence(ch) <= getPrecedence(stack.peek()))) {
                        postfix.append(stack.pop()).append(' ');
                    }
                    stack.push(ch);
                }
            } else if (ch == ')') {
                // If the next element is a closing bracket
                while (stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop();
            }
        }

        // Pop the remaining elements from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString();

    }

    /**
     * Converts infix expression to prefix notation.
     *
     * @param infix The infix expression to convert.
     * @return The prefix notation of the infix expression.
     */
    public String infixToPrefix(String infix) {
        Stack<Character> stack = new Stack<>(infix.length());
        StringBuilder postfix = new StringBuilder();

        // Reverse the infix expression
        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);

            if (ch == ' ') {
                continue;
            } else if (Character.isLetterOrDigit(ch)) {
                // If the next element is an operand, display it
                postfix.append(ch).append(' ');
            } else if (ch == ')') {
                // Push the next element on the stack if it is an opening bracket
                stack.push(ch);
            } else if (ch == '(') {
                // If the next element is a closing bracket
                while (stack.peek() != ')' && !stack.isEmpty()) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else if (OPERATORS.contains(ch)) {
                // If the next element is an operator
                if (stack.isEmpty() || stack.peek() == '(' || getPrecedence(ch) > getPrecedence(stack.peek())) {
                    stack.push(ch);
                } else {
                    while (!stack.isEmpty() && stack.peek() != '('
                            && (getPrecedence(ch) <= getPrecedence(stack.peek()))) {
                        postfix.append(stack.pop()).append(' ');
                    }
                    stack.push(ch);
                }
            }
        }

        // Pop the remaining elements from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }
        return postfix.reverse().toString();
    }

    /**
     * Gets the precedence of an operator.
     *
     * @param ch The operator character.
     * @return The precedence value of the operator.
     */
    private int getPrecedence(Character ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}