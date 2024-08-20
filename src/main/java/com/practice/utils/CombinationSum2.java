package com.practice.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0 && Math.abs(nums[i]) > 0 && Math.abs(nums[i]) - 1 < nums.length) {
                if (nums[Math.abs(nums[i]) - 1] < 0) {
                    nums[Math.abs(nums[i]) - 1] = -1;
                } else {
                    nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
//                if(nums[i]>0){
//                    return i+1;
//                }
        }
        System.out.println(nums);
        return nums.length;
    }

    public static void main(String[] args) {
//        int inp[] = {2, 1, 5, -6, 3, 4};
//        System.out.println(new CombinationSum2().firstMissingPositive(inp));

        System.out.println(new CombinationSum2().mySqrt(2147395599));
        System.out.println("Assertion"+Math.sqrt(2147395599));
    }

    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            System.out.println("low"+low+"high"+high);
            double  mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if ((mid - 1) * (mid - 1) < x && mid * mid > x) {
                return (int)mid-1;
            } else if (mid * mid > x) {
                high =(int) mid-1;
            } else {
                low = (int)mid +1;
            }
        }
        System.out.println("return");
        return x-1;

    }

}
