package thread.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinSizeSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int currentMinWindow = Integer.MAX_VALUE;
        while (j < nums.length) {
            System.out.println("i=" + i + ", j=" + j);
            currentSum += nums[j];
            if (currentSum >= target) {
                currentMinWindow = Integer.min(currentMinWindow, j - i + 1);
                currentSum -= nums[i];
                ++i;
            } else {
                ++j;
            }
            if (i == j) {
                j=i;
            }
        }
        return currentMinWindow;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        System.out.println(pq.add(13));
        System.out.println(pq.add(2));
        System.out.println(pq.add(3));
        System.out.println(pq.add(23));
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }
}
