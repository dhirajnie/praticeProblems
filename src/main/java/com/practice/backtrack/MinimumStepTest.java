package com.practice.backtrack;

import java.util.Scanner;



//    .X.
//    .X.
//    ...
//
//
//



public class MinimumStepTest
{
    public static void main( String arg[] )
    {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        String inp[] = new String[n];
        int x = 0;
        while ( n != 0 ) {
            inp[x] = sc.next();
            --n;
            ++x;

        }
        int startX = sc.nextInt();

        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();

        System.out.println( MinimumSteps.minimumMoves( inp, startX, startY, goalX, goalY ) );

    }


}
