package geeksforgeeks;

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner( System.in );
        int noOfTestcases = sc.nextInt();
        while ( noOfTestcases != 0 ) {
            --noOfTestcases;
            String orderString = "!#$%&*@^~";
            Map<Integer, Character> charMap = new TreeMap<>();
            String inp = new String();
            sc.next();
            int n = sc.nextInt();
            while ( n != 0 ) {
                inp = inp + sc.next();
                --n;
            }
            for ( int i = 0; i < inp.length(); i++ ) {
                charMap.put( orderString.indexOf( inp.charAt( i ) ), inp.charAt( i ) );
            }
            charMap.entrySet().forEach( x -> System.out.print( x.getValue() + " " ) );
            System.out.println();
            charMap.entrySet().forEach( x -> System.out.print( x.getValue() + " " ) );
            System.out.println();


        }
    }
}