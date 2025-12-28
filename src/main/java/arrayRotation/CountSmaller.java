package arrayRotation;

import com.practice.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSmaller {
  static   public int removeElement(int[] nums, int val) {
        int i=0;
        int j = nums.length-1;
        while(i<=j){
            while(i<nums.length && nums[i]!=val){
                ++i;
            }
            while(j>0 && nums[j]==val){
                --j;
            }
            if(i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        System.out.println(i+" , "+j);
        Utils.print(nums);
        return j;
    }



    public static void main(String[] args) {


        int inp[]=new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(inp,2));
    }
}
