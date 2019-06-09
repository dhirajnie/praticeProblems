package com.practice.LinkedArrayListProblems;

import java.util.*;
import java.lang.*;
import java.io.*;

class Test11 {
    private static Map<Character, Integer> conversionMap;
    static {
        conversionMap = new HashMap<>();
        conversionMap.put( 'I', 1 );
        conversionMap.put( 'V', 5 );
        conversionMap.put( 'X', 10 );
        conversionMap.put( 'L', 50 );
        conversionMap.put( 'C', 100 );
        conversionMap.put( 'D', 500 );
        conversionMap.put( 'M', 1000 );

    }

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test!=0){
            --test;
            String romanNumber = sc.next();
            int number = 0;
            for(int i=0;i<romanNumber.length()-1;i++){
                if(conversionMap.get( romanNumber.charAt( i ) )<conversionMap.get( romanNumber.charAt( i+1 ) )){
                    number = number+conversionMap.get(romanNumber.charAt( i+1 ) )-conversionMap.get( romanNumber.charAt( i ) );
                    ++i;
                }
                else{
                    number = number+conversionMap.get( romanNumber.charAt( i ) );
                }
            }
            number=number+conversionMap.get( romanNumber.charAt( romanNumber.length()-1 ) );
            System.out.println(number);
        }


    }

}