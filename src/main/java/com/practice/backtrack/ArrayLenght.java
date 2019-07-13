package com.practice.backtrack;

public class ArrayLenght
{
    public static void main(String ars[]){

        int inp[]=new int[]{1, 4 ,-1 ,3 ,2};

        int lenght=0;
        int headIndex =0;

        while(inp[headIndex]!=-1){
            headIndex= inp[headIndex];
            ++lenght;

        }
        System.out.println(lenght+1);

    }



}
