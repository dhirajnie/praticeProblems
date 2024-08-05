package com.practice;


import jdk.nashorn.internal.ir.SplitReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    List<Integer> swapAndGetList(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        List<Integer> copiedList =  Arrays.stream(nums).boxed()
                .collect(Collectors.toList());
//        int temp = copiedList.get(i);
//        copiedList.set(i,copiedList.get(j));
//        copiedList.set(j,temp);
        return copiedList;
    }

    public void recur(List<List<Integer>> lists, int i, int j, int nums[]) {
        Utils.print(nums);
        System.out.println("Index:" + i + "and j:" + j);
        if (i >= nums.length || j >= nums.length) {
            return;
        } else {
            for ( j  = i; j < nums.length; j++) {
                lists.add(swapAndGetList(nums, i, j));
                recur(lists, i+1, j, nums);
                swapAndGetList(nums, i, j);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        recur(lists, 0, 0, nums);
        return lists;
    }


    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(new Permutation().permute(nums));
        Utils.print(nums);


        System.out.println("flower".lastIndexOf("flow"));
    }
}
