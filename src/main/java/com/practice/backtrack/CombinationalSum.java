package com.practice.backtrack;

import java.util.ArrayList;
import java.util.*;

public class CombinationalSum
{
    public static List<StringBuffer>  generateBinary( int n )
    {

        List<StringBuffer> result = new ArrayList<>(  );
         result.add( new StringBuffer( "0" ) );
         result.add( new StringBuffer( "1" ) );
         for(int i =0;i<n;i++){
             int resultSize= result.size();
             for(int j =0;j<resultSize;j++)
             {
                 StringBuffer x = result.get( j );
                 result.add( x.insert( 0,"0" ) );
                 result.add( x.insert( 0,"1" ) );

             }
         }
         return result;
    }


    public static void main( String ars[] )
    {
        System.out.println(generateBinary( 2 ));
    }
}
