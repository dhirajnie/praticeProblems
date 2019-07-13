package parkingsystem;


import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.util.*;

public class ParkingSpotAlgo
{


    public static void main(String args[]){
            List<Integer> list= Arrays.asList( new Integer[]{1,2,4,5,6,16,17,18,19,60,63,64,65,66,67,68} );
            int n =5;


            List<Integer> queue = new ArrayList<>( 2 );
            queue.add( list.get( 0 ) );
            for(int i =1;i<list.size();i++){
                if(list.get( i )-queue.get( queue.size()-1 )==1){
                    queue.add( list.get( i ) );
                    if(queue.size()==n){
                        break;
                    }
                }
                else {
                    queue = new ArrayList<>( n );
                    queue.add( list.get( i ) );
                }

            }
        System.out.println(queue);




    }
}
