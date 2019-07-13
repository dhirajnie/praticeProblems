package com.practice.backtrack;

import java.util.*;


public class test
{
    public static void main( String ar[] )
    {

        int A[] = new int[] {1};
        int k = 105823341;
        System.out.println(cookies( k, A ));

    }


    static int cookies( int k, int[] A )
    {
        Queue<Integer> list = new PriorityQueue<>(  );
        for ( int i = 0; i <100000; i++ ) {
            list.add(1 );
        }
        if(list.size()<2)
        {
            return -1;
        }
        else if(list.size()<2 && list.peek()<k){
            return 0;
        }

        else{
            int counter=0;
            while (list.size()>1 &&  list.peek()< k){
                ++counter;
                int firstElement = list.poll();
                int secondElement= list.poll();
                int sweetness= firstElement+2* secondElement;
               list.add( sweetness );
            }
            if(list.peek()>=k)
                return counter;
            else{
                return -1;
            }
        }

    }


}
