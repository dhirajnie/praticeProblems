package geeksforgeeks;

import java.util.*;


public class NutsBolts
{
    public static void main( String args[] )
    {
        String orderString = "!#$%&*@^~";

        Map<Integer, Character> charMap = new TreeMap<>();
        String inp = "@%$#^";

        for ( int i = 0; i < inp.length(); i++ ) {
            charMap.put( orderString.indexOf( inp.charAt( i ) ), inp.charAt( i ) );
        }

        System.out.println( charMap );

        charMap.entrySet().forEach( x-> System.out.print(x.getValue()) );
    }
}
