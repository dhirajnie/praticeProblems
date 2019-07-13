package geeksforgeeks;

public class CoinChangeProblem
{

    static void  printTable(int table[][],int n,int m){

        for(int i=0;i<=m;i++){
            for(int j =0;j<n;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }

    }

static int min(int a,int b){
    if(a>b)
        return b;
    else
        return a;
}
    public static void main(String args[]){

        int table[][]= new int[10000][10000];

        int coins[]=new int[]{1,2};
        int required_sum=7;
        for(int j=0;j<coins.length;j++){
            table[j][0]=0;

        }
        for(int i=1;i<=required_sum;i++){
            table[0][i]=i;
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
        System.out.println("Optimim"+table[coins.length-1][required_sum]);
       // printTable(table,required_sum+1,coins.length);


    }
}
