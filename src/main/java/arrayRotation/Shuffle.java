package arrayRotation;

import java.util.Arrays;
import java.util.LinkedList;

public class Shuffle {

  static  public int[] findErrorNums(int[] nums) {
        //Set<Integer> set = new HashSet<>();
        for(int i =1;i<nums.length;i++){
            System.out.print("OK Here"+i);
            if(nums[i-1]==nums[i]){
                int res[] = new int[2];
                res[0]=nums[i];

                return res;
            }
        }


        return new int[2];
    }



    public static void main(String[] args) {
      int res[]= new int[]{1,1};
        System.out.println(Arrays.asList(findErrorNums(res)).toString());
    }
}
