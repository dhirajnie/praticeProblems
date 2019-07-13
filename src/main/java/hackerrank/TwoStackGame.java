package hackerrank;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class TwoStackGame
{
    static int counter = 0;


    static void recur( Stack<Integer> stack, int currentSum, int requiredSum )
    {
        if ( stack.empty() ) {
            return;
        }
        if ( ( currentSum + stack.peek() > requiredSum ) ) {
            return;
        }
        if ( currentSum < requiredSum ) {
            ++counter;

            int stakTopItem = stack.pop();
            currentSum = currentSum + stakTopItem;
            recur( stack, currentSum, requiredSum );
            stack.push( stakTopItem );

        }
    }


    static int twoStacks( int x, int[] a, int[] b )
    {
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();

        for ( int i = a.length - 1; i >= 0; i-- ) {
            firstStack.push( a[i] );
        }
        for ( int i = b.length - 1; i >= 0; i-- ) {
            secondStack.push( b[i] );
        }

//        System.out.println( firstStack );
//        System.out.println( secondStack );


        int maxScore = 0;
        while ( x > 0 ) {

            counter = 0;
            recur( firstStack, 0, x );
            int noOfEligibleItemFromFirstStack = counter;
            counter = 0;
            recur( secondStack, 0, x );
            int noOfEligibleItemFromSecondStack = counter;

            if ( noOfEligibleItemFromFirstStack == 0 && noOfEligibleItemFromFirstStack == noOfEligibleItemFromSecondStack ) {
                break;
            }
            if ( noOfEligibleItemFromFirstStack > noOfEligibleItemFromSecondStack ) {
                if ( !firstStack.empty() )
                    x = x - firstStack.pop();

            } else {
                if ( !secondStack.empty() ) {
                    x = x - secondStack.pop();
                }
            }

            if ( x >= 0 ) {
                ++maxScore;
            }
            if ( firstStack.empty() && secondStack.empty() ) {
                break;
            }


        }


        return maxScore;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(result);
        }


    }
}
