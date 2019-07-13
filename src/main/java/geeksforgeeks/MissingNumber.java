package geeksforgeeks;
import java.util.*;

public class MissingNumber
{

    public static void main(String ar[]){

        System.out.println( missingNumber( new int[]{0 ,-10 ,1 ,3 ,-20} ,3));
    }

    static int missingNumber(int arr[], int n) {


        Set<Integer>  set = new HashSet<>(  );
        int max=Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++)
        {
            set.add( arr[i] );
            if(max<arr[i]){
                max=arr[i];
            }

        }
        int output =-1;

        for(int i=1;i<max;i++){
            if(!set.contains( i )){
             output=i;
            }
        }
        return output;
    }

}
