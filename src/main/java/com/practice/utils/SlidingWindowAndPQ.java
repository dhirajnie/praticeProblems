package com.practice.utils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowAndPQ {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int result[] = new int[nums.length-k+1];
        int end=0;
        while(k!=0) {
            pq.add(nums[end]);
            ++end;
            --k;
        }
        int start =0;

        result[0]=pq.peek();
        for(;end<nums.length;end++){
            pq.remove(nums[start]);
            start+=1;
            if(!pq.isEmpty() && pq.peek().intValue()<nums[end]) {
                pq.add(nums[end]);
            }
            else{
                pq.add(nums[end]);
            }
            result[start]=pq.peek();
        }
        return result;
    }


    public static void main(String[] args) {
        int inp[]={1,-1};
       int result[] = new SlidingWindowAndPQ().maxSlidingWindow(inp,1);
       for(int i =0;i<result.length;i++){
           System.out.println(result[i]+",");
       }
    }
}
