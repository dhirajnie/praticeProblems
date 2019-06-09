package monoploy;

import java.util.HashSet;
import java.util.Set;


public class test12
{

    public static void main(String args[]){
        Set<Integer > set = new HashSet<>(  );
       int arr[] = {1,2,3,4,5,1,1,1,2};

       for(int x:arr){
           if(set.add( x )==false){
               set.remove( x );
           }
       }

    }
}
