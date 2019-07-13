package com.practice.backtrack;

import java.util.Scanner;


public class MatrixPath
{
    static int required_sum = 12;
    static int counter = 0;


    static void recur( int matrix[][], int i, int j, int sum )
    {

        if ( required_sum<sum ) {
            return;
        } else if ( j == matrix.length || i == matrix.length ) {
            return;
        } else if ( i == matrix.length - 1 && j == matrix.length - 1 ) {
            //  System.out.println( sum );
            sum += matrix[i][j];
            if ( required_sum == sum ) {
                ++counter;
            }
        } else {
            // System.out.println( matrix[i][j] + "->" );
            sum += matrix[i][j];
            recur( matrix, i, j + 1, sum );
            recur( matrix, i + 1, j, sum );
        }

    }


    public static void main( String args[] )
    {
        Scanner scanner = new Scanner( System.in );
        int noOfTestcases = scanner.nextInt();

        while ( noOfTestcases != 0 ) {
            required_sum = scanner.nextInt();
            int N = scanner.nextInt();
            int matrix[][] = new int[N][N];
            for ( int i = 0; i < N; i++ ) {
                for ( int j = 0; j < N; j++ ) {
                    System.out.println( matrix[0][0] );
                    matrix[i][j] = scanner.nextInt();
                }
            }
            recur( matrix, 0, 0, 0 );
            System.out.println( counter );
            --noOfTestcases;
            required_sum = 0;
            counter = 0;

        }
    }

}
