package com.practice.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NGE {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>() ;
        stack.push(nums2[0]);
        for(int i =0;i<nums2.length;i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                ngeMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            ngeMap.put(stack.pop(), -1);
        }
        System.out.println(ngeMap);
        int result[] = new int[nums1.length];
        for(int i =0;i<nums1.length;i++){
            result[i]= ngeMap.get(nums1[i]);
        }
    return result;
    }


    public static void main(String[] args) {
        int nums1[]={4,1,2};
        int nums2[]={1,3,4,2};
        System.out.println(new NGE().nextGreaterElement(nums1,nums2));
    }
}
