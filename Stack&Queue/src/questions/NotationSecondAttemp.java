package questions;

import java.util.Stack;

public class NotationSecondAttemp {
    public String infixToPostfixNotation(String infix) {
        if (infix == null || infix.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> os = new Stack<>();

        for (char ch : infix.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue;
            } else if (Character.isLetterOrDigit(ch)) {
                sb.append(ch).append(' ');
            } else if (ch == '(') {
                os.push(ch);
            } else if (ch == ')') {
                while (!os.isEmpty() && os.peek() != '(') {
                    sb.append(os.pop()).append(' ');
                }
                if (os.isEmpty()) {
                    throw new IllegalArgumentException("Invalid notation with ( ).");
                }
                os.pop(); // remove '('
            } else if (isOperator(ch)) {
                while (!os.isEmpty() && getPrecedence(ch) <= getPrecedence(os.peek())) {
                    sb.append(os.pop()).append(' ');
                }
                os.push(ch);
            } else {
                throw new IllegalArgumentException("Not a valid infix notation.");
            }
        }

        while (!os.isEmpty() && os.peek() != '(') {
            sb.append(os.pop()).append(' ');
        }

        if (!os.isEmpty()) {
            throw new IllegalArgumentException("Invalid infix notation with ( ).");
        }

        return sb.toString().trim();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^';
    }

    private int getPrecedence(char ch) {
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
            default:
                return -1;
        }
    }

    public String infixToPrefixNotation(String infix) {
        if (infix == null || infix.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = infix.length() -1; i >= 0; i--) {
            char ch = infix.charAt(i);
            if(ch == ' ') continue;
            else if ( Character.isLetterOrDigit(ch)) prefix.append(ch);
            else if ( ch == ')')  stack.push(ch);
            else if( ch== '(') {
                while(!stack.isEmpty() && stack.peek() != ')') prefix.append(ch).append(' ');
                if(stack.isEmpty()) throw new IllegalArgumentException("Invalid expression.");
                stack.pop();
            }
            else if (isOperator(ch)){
                while(!stack.isEmpty() && stack.peek() != ')' &&  getPrecedence(ch) <= getPrecedence(stack.peek())) prefix.append(stack.pop()).append(' ');
                stack.push(ch);
            }
            else throw new IllegalArgumentException("Exception : Invalid exception.");
        }
        while(!stack.isEmpty() && stack.peek() != ')') prefix.append(stack.pop()).append(' ');
        if(!stack.isEmpty()) throw new IllegalArgumentException("Invalid expression");

        return prefix.reverse().toString();
    }
}
