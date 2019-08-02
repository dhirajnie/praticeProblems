package thread.practice;

public class StrictAlternation
{
    static volatile int counter=0;
    public static void main(String args[]){
        Object lock = new Object();
        Thread t1 = new Thread( new Service(lock) );
        t1.setName( "A" );
        Thread t2 = new Thread( new Service(lock) );
        t2.setName( "B" );

            t1.start();
            t2.start();

    }

}
class Service implements Runnable
{
    Object lock;


    public Service( Object lock )
    {
        this.lock = lock;
    }


    @Override public void run()
    {   while ( StrictAlternation.counter!=10 ){
            if(StrictAlternation.counter%2==0 && Thread.currentThread().getName().equals( "A" ) ){
                synchronized ( lock ){

                        try {
                            System.out.println("Even "+Thread.currentThread().getName());
                            ++StrictAlternation.counter;
                           lock.wait();
                        } catch ( InterruptedException e ) {
                            e.printStackTrace();
                        }

                    }


                }

        if(StrictAlternation.counter%2==1 && Thread.currentThread().getName().equals( "B" ) ){
            synchronized ( lock ){

                try {
                    System.out.println("Odd "+Thread.currentThread().getName());
                    ++StrictAlternation.counter;
                    lock.notify();
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }


        }

    }


}}