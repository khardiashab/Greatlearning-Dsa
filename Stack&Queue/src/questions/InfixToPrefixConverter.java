package questions;

import java.util.Stack;

public class InfixToPrefixConverter {
    public static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        // Reverse the infix expression
        StringBuilder reversedInfix = new StringBuilder(infix).reverse();

        for (int i = 0; i < reversedInfix.length(); i++) {
            char ch = reversedInfix.charAt(i);
            if(ch == ' ') continue;

            if (Character.isLetterOrDigit(ch)) {
                // Operand: Append to prefix
                prefix.append(ch);
            } else if (ch == ')') {
                // Closing bracket: Push to operator stack
                operatorStack.push(ch);
            } else if (ch == '(') {
                // Opening bracket: Pop operators from stack until closing bracket is encountered
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')') {
                    prefix.append(operatorStack.pop());
                }
                // Pop the closing bracket
                operatorStack.pop();
            } else {
                // Operator: Pop operators from stack with higher precedence and append to prefix
                while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
                    prefix.append(operatorStack.pop());
                }
                // Push the current operator to stack
                operatorStack.push(ch);
            }
        }

        // Pop any remaining operators from stack and append to prefix
        while (!operatorStack.isEmpty()) {
            prefix.append(operatorStack.pop());
        }

        // Reverse the prefix expression to get the final result
        return prefix.reverse().toString();
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String infixExpression = "(A + B) * C - D / (E + F)";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Prefix Notation: " + prefixExpression);
    }
} 