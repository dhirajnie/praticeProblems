package thread.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PartArr {

    public int partitionDisjoint(int[] nums) {

        int leftMax[] = new int[nums.length];
        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        int rightMin[] = new int[nums.length];
        rightMin[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (leftMax[i] < rightMin[i + 1]) {
                return i+1;
            }
        }
        return  1;
    }

    public static void main(String[] args) {
        int inp[] = {1, 1, 1, 0, 6, 12};
        System.out.println(new PartArr().partitionDisjoint(inp));
    }
}
