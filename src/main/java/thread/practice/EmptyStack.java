package thread.practice;

import java.util.Stack;

public class EmptyStack {

    public boolean checkValidString(String inp) {
        if(inp==null || inp.length()==0)
            return true;

        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> paranthesis = new Stack<>();
        boolean result = true;
        for (int i = 0; i < inp.length(); i++) {
            if (inp.charAt(i) == '(') {
                openStack.push(i);
            } else if (inp.charAt(i) == '*') {
                paranthesis.push(i);
            } else {
                if (openStack.isEmpty() && paranthesis.isEmpty()) {
                    result = false;
                    break;
                } else if (!openStack.isEmpty() && inp.charAt(openStack.peek()) == '(') {
                    openStack.pop();
                } else if (!paranthesis.isEmpty()) {
                    paranthesis.pop();
                } else {
                    result = false;
                    break;
                }
            }
        }
        if (result == true && openStack.size() != 0 && paranthesis.size()!=0) {
            while(!openStack.isEmpty()&& !paranthesis.isEmpty() && openStack.peek()< paranthesis.peek()){
                openStack.pop();
                paranthesis.pop();
            }
        }
        if(openStack.size()!=0 )
            result=false;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new EmptyStack().checkValidString("((*)"));
    }
}
