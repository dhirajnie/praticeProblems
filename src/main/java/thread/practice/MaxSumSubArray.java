package thread.practice;

public class MaxSumSubArray {

    int getLowestIndex(int nums[]) {
        Integer minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 && nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int maxSubarraySumCircular(int[] nums) {

        int lowestIndex = getLowestIndex(nums);
        int current = 0;
        int max = Integer.MIN_VALUE;
        int i = (lowestIndex + 1) % (nums.length);
        int count = nums.length;
        while (count>0) {
            current = current + nums[i];
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                current = 0;
            }
            i = i + 1;
            if (i > nums.length - 1) {
                i = 0;
            }

            --count;
        }

        return max;
    }


    public static void main(String[] args) {
        int nums[] = {1,-2,3,-2};
        System.out.println(new MaxSumSubArray().maxSubarraySumCircular(nums));
    }

}
