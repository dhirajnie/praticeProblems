package thread.practice;

public class SimpleTest
{
    public static void main( String args[] )
    {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();

    }
}


class MyThread extends Thread
{


    @Override public void run()
    {   while ( true )
        System.out.println( "Running " + Thread.currentThread().getName() );
    }
}


