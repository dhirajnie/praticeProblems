package geeksforgeeks;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;


public class ExecutorServiceException
{


    public static void main(String args[]){

        ExecutorService ex= Executors.newFixedThreadPool(1);
        List<Integer> list = new ArrayList<>(  );
        list.add( 1 );
        list.add( 2 );
        ex.submit( ()->{
            System.out.println(list);
            System.out.println("Thread calling");
          int a[] = new int[2];
          a[9]=1000;

        } );


        try {
            Thread.currentThread().sleep( 10000 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println("Main method compltede");
    }
}
