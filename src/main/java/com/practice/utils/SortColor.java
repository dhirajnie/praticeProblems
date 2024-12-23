package com.practice.utils;

import com.practice.Utils;

public class SortColor {

    void swap(int nums[],int firstIndex,int scondIndex){
        int temp = nums[firstIndex];
        nums[firstIndex]= nums[scondIndex];
        nums[scondIndex]= temp;
    }

    public void sortColors(int[] nums) {

        int i =0;
        int j =0;
        int k = nums.length-1;
        while(j<k && j<nums.length){
            System.out.println("i"+i+",j"+j+",k"+k);
            if(nums[j]==0){
                swap(nums,i,j);
                ++i;
                ++j;
            }
            else if(nums[j]==2){
                swap(nums,j,k);
                --k;
            }
            else{
                ++j;
            }
        }
    }


    public static void main(String[] args) {
        int nums[]={2,0,0,1,0,1,1,1,2,2};
    new SortColor().sortColors(nums);
       Utils.print(nums);
    }
}
