package geeksforgeeks;

import java.util.*;


public class StockProblem
{

    public static void main( String args[] )
    {
        System.out.println(System.currentTimeMillis());
        Scanner sc = new Scanner( System.in );
        int noOfTestcases = sc.nextInt();
        while ( noOfTestcases != 0 ) {
            --noOfTestcases;
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>(  );
            while(n!=0) {
                list.add( sc.nextInt() );
            --n;
            //  List<Integer> list = Arrays.asList( new Integer[] { 10, 4, 5, 90, 120, 80 } );


            }
            Stack<StackEntry> stack = new Stack<>();
            Queue<StackEntry> tempStack = new LinkedList<>();
            for ( int i = 0; i < list.size(); i++ ) {

                if ( stack.isEmpty() ) {
                    stack.push( new StackEntry( list.get( i ), list.get( i ) ) );
                    System.out.print( "1 " );

                } else if ( stack.peek().min_value > list.get( i ) ) {
                    System.out.print( "1 " );
                    stack.push( new StackEntry( list.get( i ), list.get( i ) ) );
                } else {
                    int counter = 0;
                    while ( !stack.isEmpty() && stack.peek().min_value < list.get( i ) ) {
                        if ( stack.peek().value <= list.get( i ) )
                            ++counter;
                        tempStack.add( stack.pop() );
                    }
                    System.out.print( counter + 1 +" " );
                    while ( !tempStack.isEmpty() ) {
                        stack.push( tempStack.poll() );
                    }
                    stack.push( new StackEntry( list.get( i ), stack.peek().min_value ) );

                }
            }
            System.out.println();
        }

    }
}


class StackEntry
{
    int value;
    int min_value;


    public StackEntry( int value, int min_value )
    {
        this.value = value;
        this.min_value = min_value;
    }


    public int getValue()
    {
        return value;
    }


    public void setValue( int value )
    {
        this.value = value;
    }


    public int getMin_value()
    {
        return min_value;
    }


    public void setMin_value( int min_value )
    {
        this.min_value = min_value;
    }
}
