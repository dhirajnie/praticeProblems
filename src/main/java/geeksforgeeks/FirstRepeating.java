package geeksforgeeks;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class FirstRepeating
{
    public static void main( String args[] )
    {
        List<Integer> list = Arrays.asList( new Integer[] { 11, 11, 2, 5, 4, 3, 2 } );
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger index = new AtomicInteger( 0 );

        for ( Integer x : list ) {
            if ( map.containsKey( x ) ) {
                System.out.println( map.get( x ) );
                break;
            } else {
                map.put( x, index.incrementAndGet() );
            }
        }

    }
}




