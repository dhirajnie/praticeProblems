package com.practice.utils;

import java.util.*;

public class NGE {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                ngeMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            ngeMap.put(stack.pop(), -1);
        }
        System.out.println(ngeMap);
        int result[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.get(nums1[i]);
        }
        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        //stack contaning index
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            System.out.println("stack"+stack);
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};
        int nums2[] = {1, 3, 4, 2};
//        System.out.println(new NGE().nextGreaterElement(nums1,nums2));
        int tempratures[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(new NGE().dailyTemperatures(tempratures));
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        System.out.println(  maxHeap.peek());

    }
}
