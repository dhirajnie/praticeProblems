package geeksforgeeks;

import java.util.Stack;


public class TinyUrl
{

    static String base62Map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    public static void main( String args[] )
    {
        int num = 12345;
        int output = num;
        Stack<Integer> stack = new Stack<>();
        while ( num != 0 ) {
            int x = num % 62;
            num = num / 62;
            stack.push( x );
        }
        String result;

        while ( stack.empty() != true ) {
          System.out.print( ( base62Map.charAt( stack.pop()  ) ));
          //  System.out.println(stack.pop());
        }
        System.out.println(num);
    }
}
