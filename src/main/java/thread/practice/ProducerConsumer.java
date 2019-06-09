package thread.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProducerConsumer
{
    static ExecutorService executor = Executors.newFixedThreadPool( 2 );


    public static void main( String args[] )
    {

        CriticalSection criticalSection = new CriticalSection();

        executor.submit( () -> {
                //Producer

                System.out.println( "Starting producer" );
                try {
                    criticalSection.produce();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }

            }

        );
        executor.submit( () -> {
            //consumer

            System.out.println( "Starting consumer" );
            try {
                criticalSection.consume();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }


        } );


    }
}


class CriticalSection
{
    Queue queue = new LinkedList();
    final int LIMIT = 10;


     void consume() throws InterruptedException
    {
        while ( true ) {
            synchronized ( this ) {
                if ( queue.isEmpty() ) {
                    System.out.println( "Consumer is going to sleep" );
                    wait();
                }
                System.out.println( "Consuming item" + queue.poll() );
                Thread.sleep( 1000 );
                notify();
            }

        }
    }


     void produce() throws InterruptedException
     {
         int item = 0;
         while ( true ) {
        synchronized ( this ){
                 if ( queue.size() == LIMIT ) {
                     System.out.println( "Producer is going to sleep" );
                     wait();
                 }
                 queue.add( item );
                 System.out.println( "Producing item " + item );
                 ++item;
                 Thread.sleep( 1000 );
                 notify();
             }

     }}

}
