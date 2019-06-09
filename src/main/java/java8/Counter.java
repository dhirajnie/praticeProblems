package java8;

import java.util.Arrays;
import java.util.List;


public class Counter
{
    public static void main(String args[]){
        List<String> list = Arrays.asList( "abcd","def","dhhi" );
        int totalcount = (int) list.stream().count();
        System.out.println(totalcount);



    }
}
