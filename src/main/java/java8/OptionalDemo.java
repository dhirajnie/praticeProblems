package java8;

import java.util.*;


public class OptionalDemo
{
// USE LESS WRAPPER

    public static void main(String arg[]){
        List<String> list = Arrays.asList( "abcd","def","dhhi" );

        list.stream().filter( x->x.equalsIgnoreCase( "abcd" ) ).forEach( x-> System.out.println(x) );

        Optional<Integer> sum =Optional.ofNullable( sum(12) );

        if ( sum.isPresent() ) {
            System.out.println(sum.get());
        }
        System.out.println(sum.orElse( 123 ));

    }

   static Integer sum(int x){
        if(x==1){
           return x;
        }
        else{
            return null;
        }
    }

}
