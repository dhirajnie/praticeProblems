package puzzles;

import com.sun.javafx.collections.MappingChange;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class NoOfSquare
{


    public static void main( String args[] )
    {

        List<Integer> list = Arrays.asList( new Integer[] { 112, 3, 4, 5, 6 } );


        Map<Integer, Integer> map = new TreeMap<>();
        list.stream().forEach( x-> {
            if(map.containsKey( x )){
                map.put(x,map.get( x )+1);
            }
            else{
                map.put(x,1);
            }
        });
        AtomicInteger i = new AtomicInteger( 0 );
        Integer v = new Integer( 12 );

        map.entrySet().stream().map(x->x.setValue( x.getValue()+v  ));
        





    }
}
