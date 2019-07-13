package geeksforgeeks;

import java.util.*;


public class RectangleDimension
{


    public static void main( String args[] )
    {

        Scanner sc = new Scanner( System.in );
        int testCases = sc.nextInt();
        while ( testCases != 0 ) {
            --testCases;
            List<Integer> factorList = getFactors( sc.nextInt());

            int i = 0;
            int j = factorList.size() - 1;
            int counter = 0;
            while ( i <= j ) {
                int num1 = factorList.get( i );
                int num2 = factorList.get( j );
                if ( i == j && num1 % 2 == 0 ) {
                    ++counter;
                }
                if ( !( num1 % 2 == 0 && num2 % 2 == 0 ) ) {
                    ++counter;
                }
                ++i;
                --j;

            }

            System.out.println( counter );

        }
    }


        static List<Integer> getFactors ( int num )
        {

            List factorList = new ArrayList();
            factorList.add( 1 );
            int tempNum = num;

            for ( int i = 2; i <= num / 2; i++ ) {
                if ( tempNum % i == 0 ) {
                    factorList.add( i );

                }
            }
            factorList.add( num );
            return factorList;
        }
    }
