package arrayRotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedNumber {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
    for(int i =0;i<nums.length;i++){
        if( nums[Math.abs(nums[i])-1] >0){
            nums[Math.abs(nums[i])-1]= -1* nums[Math.abs(nums[i])-1];
        }
    }
    List<Integer> result = new ArrayList<>();

    for(int i =0;i<nums.length;i++){
        if(nums[i]>0){
            result.add(i+1);
        }
    }

        System.out.println(Arrays.toString(nums));
    return result;
    }

    public static void main(String[] args) {
        int input [] = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(input));
    }
}
