package thread.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0;i<nums.length;i++){
            queue.add(nums[i]);
        }

        while(k-1!=0){
            queue.poll();
            --k;
        }

        return queue.poll();

    }


    public static void main(String[] args) {
        int nums[]={3,2,1,5,6,4};
        int k =2;
        System.out.println(new KthLargest().findKthLargest(nums,k));
    }
}
