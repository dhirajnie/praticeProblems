package com.practice.utils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class Test123
{

    static Queue<Integer> minHeapQueue = new PriorityQueue<>();
    static Queue<Integer> maxHeapQueue = new PriorityQueue<>( Collections.reverseOrder() );


    static void getMin()
    {
        if ( minHeapQueue.isEmpty() && maxHeapQueue.isEmpty() ) {
            System.out.println( "Wrong!" );
        } else if ( minHeapQueue.size() == maxHeapQueue.size() ) {
            BigDecimal bigDecimal = new BigDecimal( ( (long) minHeapQueue.peek() + (long) maxHeapQueue.peek() ) );

            formatOutput( bigDecimal.divide( new BigDecimal( 2 ) ) );
        } else {
            formatOutput( new BigDecimal( maxHeapQueue.peek() ) );
        }
    }


    static void addElementInQueue( int element )
    {
        if ( minHeapQueue.size() == maxHeapQueue.size() ) {
            if ( maxHeapQueue.isEmpty() ) {
                maxHeapQueue.add( element );
            } else {
                if ( element < maxHeapQueue.peek() ) {
                    maxHeapQueue.add( element );
                } else {
                    minHeapQueue.add( element );
                    int minElement = minHeapQueue.poll();

                    maxHeapQueue.add( minElement );
                }
            }
        } else {
            if ( maxHeapQueue.peek() > element ) {
                maxHeapQueue.add( element );
                int maxElement = maxHeapQueue.poll();
                minHeapQueue.add( maxElement );
            } else {
                minHeapQueue.add( element );
            }

        }
    }


    static boolean removeElement( int element )
    {
        if ( maxHeapQueue.contains( element ) ) {
            maxHeapQueue.remove( element );
            return true;
        } else if ( minHeapQueue.contains( element ) ) {
            minHeapQueue.remove( element );
            return true;
        } else {
            System.out.println( "Wrong!" );
            return false;
        }

    }


    private static void rebalanceBothQueue()
    {
        if ( maxHeapQueue.size() > minHeapQueue.size() ) {
            while ( maxHeapQueue.size() - minHeapQueue.size() > 2 ) {
                minHeapQueue.add( maxHeapQueue.poll() );
            }
        } else {
            while ( minHeapQueue.size() > maxHeapQueue.size() ) {
                maxHeapQueue.add( minHeapQueue.poll() );

            }
        }
    }


    public static void main1( String args[] )
    {

        for ( int i = 1; i < 11; i++ ) {
            addElementInQueue( i );
            System.out.println( maxHeapQueue );
            System.out.println( minHeapQueue );

            System.out.println( "--------------------------" );
        }

    }


    static final Scanner sc = new Scanner( System.in );


    static void printBothQueue()
    {

        System.out.println( maxHeapQueue );
        System.out.println( minHeapQueue );

        System.out.println( "--------------------------" );
    }


    public static void main( String ar[] )
    {

        int testCases = sc.nextInt();


        while ( testCases != 0 ) {

            String operation = sc.next();
            int number = sc.nextInt();
            //  System.out.println( operation + " " + number );


            if ( operation.equals( "r" ) ) {
                if ( removeElement( number) ) {
                    rebalanceBothQueue();
                    //  System.out.println( getMin() != -1 ? getMin() : "Wrong!" );
                    getMin();
                }

            } else {

                addElementInQueue( number );
                rebalanceBothQueue();
                //  System.out.println( getMin() != -1 ? getMin() : "Wrong!" );
                getMin();
            }
            // printBothQueue();
            --testCases;

        }
    }


    static void formatOutput( BigDecimal result )
    {


        if ( result.doubleValue() % 1 == 0 ) {
            System.out.println( result.intValue() );
        } else {
            System.out.println( result );
        }

    }


    static int getRandom()
    {
        Random rand = new Random();
        return rand.nextInt( 1000 );
    }
}
