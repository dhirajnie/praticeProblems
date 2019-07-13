package thread.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test
{


    public static void main( String args[] )
    {

        List<String> list = new ArrayList<>();
        list.add( "dhiraj" );
        list.add( "fds" );
        list.add( "Ram" );
        //   list.stream().peek( x-> System.out.println(x) ).forEach( x-> System.out.println(x) );

        Stream.of( "one", "two", "three", "four" ).filter( e -> e.length() > 3 )
            .peek( e -> System.out.println( "Filtered value: " + e ) ).map( String::toUpperCase )
            .peek( e -> System.out.println( "Mapped value: " + e ) ).collect( Collectors.toList() );

        



    }

}