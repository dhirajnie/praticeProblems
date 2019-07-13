package geeksforgeeks;

import java.util.*;


public class SmallestPositiveMissing
{
    public static void main( String args[] )
    {
        Scanner sc = new Scanner( System.in );
        int noOfTestcases = sc.nextInt();
        while ( noOfTestcases != 0 ) {
            --noOfTestcases;

            boolean map[] = new boolean[100];

            List<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            for ( int i = 0; i < n; i++ ) {
                list.add( sc.nextInt() );
            }

            for ( Integer x : list ) {
                if ( x > 0 ) {
                    map[x] = true;
                }
            }


            // System.out.println( map );
            boolean found = false;
            int i = 1;
            for ( ; i <= map.length; i++ ) {
                if ( !map[i] ) {
                    found = true;
                    System.out.println( i );
                    break;
                }
            }
            if ( !found ) {
                System.out.println( i + 1 );
            }
        }
    }
}
