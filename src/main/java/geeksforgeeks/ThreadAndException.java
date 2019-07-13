package geeksforgeeks;

public class ThreadAndException
{




    public static void main(String at[]){
        while ( true ) {
            DemoThread d = new DemoThread();
            d.start();
        }
    }
}
class DemoThread extends Thread{



    public void run(){
        System.out.println(10/0);
        System.out.println("THread running ");
    }
}
