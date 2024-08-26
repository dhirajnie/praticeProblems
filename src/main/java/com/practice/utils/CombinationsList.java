package com.practice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsList {

    List<List<Integer>> results = new ArrayList<>();

    public void recur(List<Integer> inp, int[] nums, int startIndex) {
        if (inp.size() > 0 && startIndex < nums.length && inp.get(inp.size() - 1) > nums[startIndex]) {
            return;
        }
//        if (inp.size() == k) {
        results.add(inp);
//            return;
//        }

        for (int i = startIndex; i < nums.length; i++) {
            List<Integer> clonedNumber = new ArrayList<>();
            clonedNumber.addAll(inp);
            clonedNumber.add(nums[i]);
            recur(clonedNumber, nums, i + 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        int nums[] = {6,5,4};
        Arrays.sort(nums);
        recur(new ArrayList<>(), nums, 0);
        return results;
    }


//    public List<List<Integer>> subsets(int[] nums) {
//
//    }


    public static void main(String[] args) {
        System.out.println(new CombinationsList().combine(3, 2));
    }
}
