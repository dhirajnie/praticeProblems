package com.practice.utils;

import java.util.HashMap;
import java.util.Map;

public class SortArray {

    public int subarraySum(int[] inp, int targetSum) {
        int result =0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for (int i = 0; i < inp.length; i++) {
            sum += inp[i];
            System.out.print("sum->"+sum);
            if(map.containsKey(sum - targetSum)){
                result+=map.get(sum-targetSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return result;
    }


    public static void main(String[] args) {
        int inp[]={-1,0,1,2,1,-1};
        int inp2[]={2,0,0,-1,1,1,1};
        System.out.println(new SortArray().subarraySum(inp,2));
    }
}
