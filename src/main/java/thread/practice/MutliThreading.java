package thread.practice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class MutliThreading
{
    static ExecutorService executor = Executors.newFixedThreadPool( 2 );


    public static void main( String arg[] ) throws ExecutionException, InterruptedException, TimeoutException
    {

        System.out.println( "Thread completed" + Thread.currentThread().getName() );



        Future<Integer> future = executor.submit( () -> {
                System.out.println( Thread.currentThread().getName() );
                try {

                    Thread.currentThread().sleep( 4000 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                for ( int i = 0; i < 1000000; i++ ) {
                    for ( int j = 0; j < 10000; j++ ) {
                    }
                }

                System.out.println( "Thread completed" + Thread.currentThread().getName() );
                return 23;
            }

        );
        Future<Integer> future1 = executor.submit( () -> {
            System.out.println( Thread.currentThread().getName() );
            for ( int i = 0; i < 10; i++ ) {
                for ( int j = 0; j < 10; j++ ) {
                }

            }
            System.out.println( "Thread completed" + Thread.currentThread().getName() );
            return 4321;

        } );

        //BLOCKING CALL
        int result = future.get()+future1.get();
        System.out.println(result);

        System.out.println( "Thread complted " );
    }
}
