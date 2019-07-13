package com.practice.backtrack;

public class RemoveBallon
{
    public static void main( String a[] )
    {
        String inp = "BAOOLLNNOLOLGBAX";
        String pattern = "BALLOON";


        StringBuffer testString = new StringBuffer( "LOONN" );

        boolean tryPass = true;
        int count = 0;
        while ( tryPass && testString.length() > 0 ) {

            for ( int i = 0; i < pattern.length(); i++ ) {
                int index = testString.indexOf( String.valueOf( pattern.charAt( i ) ) );
                if ( index < 0 ) {
                    tryPass = false;
                    break;
                } else {
                    testString.deleteCharAt( index );

                }
            }
            if(tryPass){
                ++count;
            }

        }
        System.out.println( count  );
    }
}
