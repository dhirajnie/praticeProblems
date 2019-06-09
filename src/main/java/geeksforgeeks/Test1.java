package geeksforgeeks;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Test1
{
    public static void main( String args[] )
    {


        String version1 = "2.4.1.1";
        String version2 = "2.4.1.1";
        System.out.println(  compareVersion( version1, version2 ));

    }


    static int compareVersion( String version1, String version2 )
    {

        int index = 0;
        while ( index < version1.length() && index < version2.length() ) {
            if ( version1.charAt( index ) == version2.charAt( index ) ) {
                ++index;
                continue;
            } else if ( version1.charAt( index ) > version2.charAt( index ) ) {
                return 1;
            } else {
                return -1;
            }
        }

        if(index==version1.length()&& index== version2.length()){
            return 0;
        }

        if(index==version1.length()){
            return -1;
        }
        else{
            return 1;
        }
    }
}
