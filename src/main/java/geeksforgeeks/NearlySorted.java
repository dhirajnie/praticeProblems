package geeksforgeeks;

import java.util.PriorityQueue;
import java.util.Scanner;


public class NearlySorted
{
    static final Scanner scanner = new Scanner( System.in );


    public static void main( String args[] )
    {
        int noOfTest = scanner.nextInt();
        while ( noOfTest != 0 ) {
            int size = scanner.nextInt();
            --noOfTest;

            int windowSize = scanner.nextInt();
            int n = windowSize;
            int arr[] = new int[size];
            int i;
            for ( i = 0; i < size; i++ ) {
                arr[i] = scanner.nextInt();
            }


            PriorityQueue<Integer> queue = new PriorityQueue<>();
            i = 0;
            while ( n != 0 ) {
                queue.add( arr[i] );
                ++i;
                --n;

            }
            for ( i = windowSize; i < arr.length; i++ ) {

                System.out.print( queue.poll()+" " );
                queue.add( arr[i] );

            }
            while ( !queue.isEmpty() ) {
                System.out.print( queue.poll() +" ");
            }
            System.out.println();
        }
    }
}