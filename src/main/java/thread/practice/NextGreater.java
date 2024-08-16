package thread.practice;

import java.util.Stack;

public class NextGreater {


    public int longestValidParentheses(String inp) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int max = 0;
        indexStack.push(-1);
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == ')') {
                if (!charStack.isEmpty() && charStack.peek() == '(') {
                    charStack.pop();
                    indexStack.pop();
                    max = Integer.max(i - indexStack.peek(), max);
                } else {
                    indexStack.push(i);
                }
            } else {
                charStack.push('(');
                indexStack.push(i);
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {

        System.out.println(new NextGreater().longestValidParentheses("(()))"));
    }

}
