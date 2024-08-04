package thread.practice;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    Map<Integer,Integer> minStepMap = new HashMap<>();
    public int recur(int nums[], int currentIndex) {
        System.out.println("recur:"+currentIndex);
        if (currentIndex >= nums.length - 1) {
            return 0;
        }
        else if(nums[currentIndex]==0){
            return nums.length;
        }
        else if(minStepMap.containsKey(currentIndex)){
            return minStepMap.get(currentIndex);
        }
        else {
            int minJumpCount = nums.length;
            for (int i = 1; i <= nums[currentIndex]; i++) {
                    minJumpCount = Integer.min(1 + recur(nums, currentIndex + i), minJumpCount);
            }
            minStepMap.put(currentIndex,minJumpCount);
            return minJumpCount;
        }
    }

    public int minNumberOfJump(int[] nums) {

        return recur(nums, 0);
    }

    public static void main(String[] args) {
        // 2 2 0 5 3 2 1 0 2
        int inp[] = {2,3,0,1,4};
        System.out.println(new JumpGame().minNumberOfJump(inp));
/*
3,2,1,0,4
 4 true
 3 false
 2 false
 map(index,possibility)
 */
    }
}
