package java8;

import java.util.*;
import java.util.stream.Collectors;


public class PracticeDay1
{
    public static void main( String args[] ) throws InterruptedException
    {
        List<Map<String, String>> listOfMap = new ArrayList<>();

        Map<String, String> nameMap = new HashMap<>();
        nameMap.put( "name", "dhirja" );
        nameMap.put( "age", "123" );
        nameMap.put( "sex", "male" );


        Map<String, String> nameMap1 = new HashMap<>();
        nameMap1.put( "name", "dhira" );
        nameMap1.put( "age", "12345" );
        nameMap1.put( "sex", "male" );
        listOfMap.add( nameMap1 );
        listOfMap.add( nameMap );

        //        listOfMap.add( nameMap );
        //        listOfMap.add( nameMap1 );
        //
        //
        Optional<String> reduced = nameMap1.entrySet().stream().map( x -> x.getKey() ).reduce( ( x1, y1 ) -> x1 + y1 );


        nameMap.entrySet().stream().forEach( x -> System.out.println( x.getValue() ) );
        Optional<String> newList = listOfMap.stream().map( x -> {
            Optional<String> result = x.entrySet().stream().map( y -> y.getValue() ).reduce( ( y1, y2 ) -> y1 + y2 );
            return result.get();
        } ).reduce( ( x1, y1 ) -> x1 + y1 );
        System.out.println( newList );


        nameMap.values().stream().forEach( x-> System.out.println("Map"+x) );






    }
}
