package java8;

import java.util.HashMap;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MapDemo
{
    public static void main(String args[]){

        //find frequency of words
        String abc="accddddd";
        Map<Integer, String> nameMap = new HashMap<>();

        IntStream.range( 0,abc.length() ).map( x->abc.charAt( x ) ).forEach(x->{
                System.out.println((char)x);
            }

        );



    }
}
