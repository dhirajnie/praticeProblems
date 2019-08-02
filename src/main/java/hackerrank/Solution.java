package hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
import static java.lang.System.in;

class Prime{

    static int  size=1000;

    public static boolean primeMap[]=new boolean[size];
    static {
        buildMap();
    }

    public static void buildMap(){

        for(int  i=2;i<(int)Math.sqrt(size);i++){
            int j= i+i;
            if(!primeMap[i]){
                while (j<size){
                    primeMap[j]=true;
                    j=j+i;
                }
            }
        }
    }

    void checkPrime(int ...numbers ){
        for(int n:numbers){

             for(int i =1;i<n;i++){
                if(!primeMap[i]){
                    System.out.print(n+" ");

             }
            }
            System.out.println();
        }
    }
}



public class Solution {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}

