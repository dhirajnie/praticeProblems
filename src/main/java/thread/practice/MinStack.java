package thread.practice;

import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (minStack.peek().intValue() > val) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (!minStack.isEmpty() && !stack.isEmpty() && minStack.peek().intValue() == stack.peek().intValue()) {
            stack.pop();
            minStack.pop();
        } else if (!stack.isEmpty()) {
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


}
