package com.practice.backtrack;

import java.util.*;


public class PossibleSum
{
    static Set<List> finalResult = new HashSet<>();


    static void recur( int input[], int currentSum, List<Integer> list, int requiredSum )
    {


        if ( currentSum == requiredSum ) {
            //  System.out.println( "OK" + list );
            List<Integer> newList = new ArrayList<>();
            newList.addAll( list );
            finalResult.add( newList );
            return;

        } else {
            for ( int i = 0; i < input.length; i++ ) {
                if ( list.size() > 1 && list.get( list.size() - 1 ) > input[i] ) {
                    continue;
                } else if ( currentSum + input[i] > requiredSum )
                    continue;
                else {
                    list.add( input[i] );
                    recur( input, currentSum + input[i], list, requiredSum );

                    list.remove( list.size() - 1 );
                }
            }
        }


    }


    public static void main( String args[] )
    {
        int input[] = { 1,2,3 };
        recur( input, 0, new ArrayList<>(), 5 );
        System.out.println( finalResult );

    }
}
