import java.util.Stack;

public class StackCombined {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if(!minStack.isEmpty() ){
            if(minStack.peek()>val)
                minStack.push(val);
        }
        else{
            minStack.push(val);
        }


    }

    public void pop() {
        Integer poppedItem = stack.pop();
        if(minStack.peek().intValue()==poppedItem.intValue()){
            minStack.pop();
        }
        System.out.println("MinStack:" + minStack);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackCombined stackCombined= new StackCombined();
        stackCombined.push(-2);
        stackCombined.push(0);
        stackCombined.push(-3);
        System.out.println(stackCombined.getMin());
       stackCombined.pop();
        System.out.println(stackCombined.top());
        System.out.println(stackCombined.getMin());
    }
}
