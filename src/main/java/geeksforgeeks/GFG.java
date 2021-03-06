package geeksforgeeks;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{

    static void  printTable(long table[][],int n,int m){

        for(int i=0;i<=m;i++){
            for(int j =0;j<n;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }

    }

    static long min(long a,long b){
        if(a>b)
            return b;
        else
            return a;
    }
    static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        int test= sc.nextInt();
        while(test!=0){

            --test;


            int required_sum=sc.nextInt();

            int noOfCoins = sc.nextInt();

            long table[][]= new long[noOfCoins+1][required_sum+1];

            int coins[]=new int[noOfCoins];

            for(int i =0;i<noOfCoins;i++){
                coins[i]=sc.nextInt();
            }
            Arrays.sort( coins );

            for(int j=0;j<coins.length;j++){
                table[j][0]=0;

            }
            for(int i=1;i<=required_sum;i++) {
                if ( i % coins[0] == 0 ) {
                    table[0][i] = i / coins[0];
                } else {
                    table[0][i] = Integer.MAX_VALUE;
                }
            }



            for(int i=1;i<coins.length;i++){
                for(int j=1;j<=required_sum;j++)
                {
                    if(coins[i]<=j){
                        table[i][j]= min(table[i][j-coins[i]]+1,table[i-1][j]);
                    }
                    else{
                        table[i][j]=table[i-1][j];
                    }
                }
            }
            System.out.println(table[coins.length-1][required_sum]);
           //  printTable(table,required_sum+1,coins.length);
        }
    }
}