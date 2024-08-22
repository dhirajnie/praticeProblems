package com.practice.utils;

import java.util.*;

class Counter {
    int count;
    int index;

    public Counter(int count, int index) {
        this.count = count;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "count=" + count +
                ", index=" + index +
                '}';
    }
}

class MyComp implements Comparator<Counter> {

    @Override
    public int compare(Counter o1, Counter o2) {
        return o1.count - o2.count;
    }
}

class Solution {
    public int[] topKFrequent(int[] inp, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inp.length; i++) {
            map.put(inp[i], map.getOrDefault(inp[i], 0) + 1);
        }
        PriorityQueue<Counter> pq = new PriorityQueue<Counter>(new MyComp());


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (pq.size() < k) {
                pq.add(new Counter(entry.getValue(), entry.getKey()));
            } else {
                if (entry.getValue() > pq.peek().count) {
                    pq.poll();
                    pq.add(new Counter(entry.getValue(), entry.getKey()));
                }
            }
        }
        System.out.println(pq);
        int res[] = new int[pq.size()];
        int x = 0;
        while (!pq.isEmpty()) {
            res[x] = pq.poll().index;
            ++x;
        }
        return res;

    }

    public static void main(String[] args) {
        int inp[]={0,1,2,3,3,4,4,5};
        System.out.println(new Solution().topKFrequent(inp,3));
    }
}

