package arrayRotation;

import com.practice.Utils;

import java.util.*;

public class CountSmaller {
    static public int removeElement(int[] nums) {

        int write = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 1 || nums[write] != nums[i]) {
                ++write;
                nums[write] = nums[i];
                if (write > 0 && nums[write] == nums[write - 1]) {
                    ++count;
                } else {
                    count = 0;
                }


            }

        }
        return write;
    }

    static public int maxProfit(int[] prices) {
     // buy and sell only once
        int minPrice =Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=0;i<prices.length;i++){
            minPrice = Integer.min(minPrice,prices[i]);
            maxProfit=Integer.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }

   static public boolean canJump(int[] nums) {
       int maxJump=0;
        for(int i  =0;i<nums.length;i++){
            if(i>maxJump){
                return false;
            }
            if(i+nums[i]> maxJump){
                maxJump=i+nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int inp[] = new int[]{3, 1, 1, 0, 6, 4};
        System.out.println(((canJump(inp))));
        Utils.print(inp);
    }
}
