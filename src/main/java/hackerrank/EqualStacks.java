package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class EqualStacks
{

//    int getMaxTopElement( Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3, int sum1, int sum2, int sum3 )
//    {
//        if ( stack1.peek() > stack2.peek() && stack1.peek() > stack3.peek() ) {
//            return sum1 - stack1.peek();
//        } else if ( stack2.peek() > stack1.peek() && stack2.peek() > stack3.peek() ) {
//            return sum2 - stack2.peek();
//        }
//
//
//    }



    static int equalStacks( int[] h1, int[] h2, int[] h3 )
    {
        Stack<Integer> f1 = new Stack<>();
        Stack<Integer> f2 = new Stack<>();
        Stack<Integer> f3 = new Stack<>();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for ( int i = h1.length - 1; i >= 0; --i ) {
            f1.push( h1[i] );
            sum1 += h1[i];
        }
        for ( int i = h2.length - 1; i >= 0; --i ) {
            f2.push( h2[i] );
            sum2 += h2[i];
        }
        for ( int i = h3.length - 1; i >= 0; --i ) {
            f3.push( h3[i] );
            sum3 += h3[i];

        }
        while ( true ) {
            System.out.println("Hello");
            if ( sum1 >= sum2 && sum1 >= sum3 ) {
                sum1 = sum1 - f1.pop();
                while(sum2>sum1){
                    sum2= sum2-f2.pop();
                }
                while(sum3>sum1){
                    sum3=sum3-f3.pop();
                }

                if(sum1==sum2 && sum1==sum3){
                    break;
                }
            }
          else   if ( sum2 >= sum1 && sum2 >= sum3 ) {
                sum2 = sum2 - f2.pop();
                while(sum1>sum2){
                    sum1= sum1-f1.pop();
                }
                while(sum3>sum2){
                    sum3=sum3-f3.pop();
                }

                if(sum1==sum2 && sum1==sum3){
                    break;
                }
            }
            else if ( sum3 >= sum1 && sum3 >= sum2) {
                sum3 = sum3 - f3.pop();
                while(sum1>sum3){
                    sum1= sum1-f1.pop();
                }
                while(sum2>sum3){
                    sum2=sum2-f2.pop();
                }

                if(sum1==sum2 && sum1==sum3){
                    break;
                }
            }
            else{break;}
            if(sum1==sum2 && sum1==sum3){
                break;
            }


        }
        System.out.println(sum1);
return sum1;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {


        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

    }
}
