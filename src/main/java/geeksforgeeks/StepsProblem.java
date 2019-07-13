package geeksforgeeks;

import java.util.*;


public class StepsProblem
{
    static int ways[] = new int[1000000];
    static int counter = 0;


    static void recur( int n, List<Integer> steps, int m )
    {

        if ( ways[n] != 0 ) {
            System.out.println( "From table" );
            ways[m] = ways[n] + counter;
            return;
        }

        if ( n < 0 )
            return;
        if ( n == 0 ) {
            ++counter;
            ways[m] = steps.size();
            return;

        } else {

            steps.add( 1 );
            recur( n - 1, steps, m );
            steps.remove( steps.size() - 1 );
            if ( steps.size() > 0 && steps.get( steps.size() - 1 ) < 2 ) {
                return;
            }
            steps.add( 2 );
            recur( n - 2, steps, m );
            steps.remove( steps.size() - 1 );

        }

    }


    public static void main( String args[] )
    {

        int n = 10;
        if ( ways[n] != 0 ) {

        }
        recur( n, new ArrayList<>(), n );
        System.out.println( "Counter" + counter );
        ways[n] = counter;

    }
}
