package thread.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadOnCriticalSection
{
    int a = 10;

    static ExecutorService executor = Executors.newFixedThreadPool( 2 );


    public static void main( String args[] )
    {
        int x = 10;
        CommonSection commonSection = new CommonSection();
        executor.submit( () -> {
            try {
                commonSection.fun( Thread.currentThread().getName() );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }

        } );
        executor.submit( () -> {
            try {
                commonSection.staticFun( Thread.currentThread().getName() );
            } catch ( Exception e ) {
                e.printStackTrace();
            }

        } );

        executor.shutdown();
    }
}


class CommonSection
{

    int variable = 10;

    Lock lock = new ReentrantLock(  );
    public synchronized void fun( String threadName ) throws InterruptedException
    {
        System.out.println( "Accessing common space " + threadName );
        System.out.println( "Going to sleep" );
        Thread.sleep( 5000 );
        System.out.println( "Awake" );
    }


    public static void staticFun( String threadName )
    {
        System.out.println( "static thread" );
    }


    public void lockInThisMethod(){
        System.out.println("Going to lock");
        lock.lock();
    }
    public void unlockInThisMethod(){
        System.out.println("Going to unlock");
        lock.unlock();
    }
}

