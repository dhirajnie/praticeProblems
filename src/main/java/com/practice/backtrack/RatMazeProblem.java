package com.practice.backtrack;

import sun.security.krb5.internal.PAData;

import java.util.*;

public class RatMazeProblem
{

    static List<String> result = new ArrayList<>();
    static boolean visited[][] = new boolean[10][10];


    public static void recur( int path[][], int i, int j, StringBuffer pathTracker, int N )
    {

        if ( i == N || j == N || i < 0 || j < 0 ) {
            return;
        } else if ( i == N - 1 && j == N - 1 ) {
            //  System.out.println( "Destination reached" + pathTracker );

            result.add( ( pathTracker.toString() ) );


        } else {
            visited[i][j] = true;


            if ( i+1 < N && !visited[i + 1][j] && path[i + 1][j] > 0 ) {
                pathTracker.append( "D" );
                recur( path, i + 1, j, pathTracker, N );
                pathTracker.deleteCharAt( pathTracker.length() - 1 );
            }


            if ( j+1 < N && !visited[i][j + 1] && path[i][j + 1] > 0 ) {
                pathTracker.append( "R" );
                recur( path, i, j + 1, pathTracker, N );
                pathTracker.deleteCharAt( pathTracker.length() - 1 );
            }

            if ( i-1 >= 0 && !visited[i - 1][j] && path[i - 1][j] > 0 ) {
                pathTracker.append( "U" );
                recur( path, i - 1, j, pathTracker, N );
                pathTracker.deleteCharAt( pathTracker.length() - 1 );

            }
            if ( j-1 >= 0 && !visited[i][j - 1] && path[i][j - 1] > 0 ) {
                pathTracker.append( "L" );
                recur( path, i, j - 1, pathTracker, N );
                pathTracker.deleteCharAt( pathTracker.length() - 1 );
            }
            visited[i][j] = false;

        }
    }


    public static void main( String args[] )
    {
        int N = 4;

        int path[][] = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };


        StringBuffer pathTracker = new StringBuffer();

        recur( path, 0, 0, pathTracker, N );
        Collections.sort( result );
        System.out.println( result );
        return;


    }
}
