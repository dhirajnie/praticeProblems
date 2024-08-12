package thread.practice;

import java.util.*;


class Node {
    int sum;
    int i;
    int j;

    public Node(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Node{" +
                "sum=" + sum +
                ", i=" + i +
                ", j=" + j +
                '}';
    }
}

public class KPair {

    public int maxSubArray(int[] nums) {
        int current =0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){

            current = current + nums[i];

            if(current >max){
                max= current;
            }
            if(current<0 ){
                current =0;
            }

        }


        if(current>max && current !=0 )
            max=current;
        return max;

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getSum));
        Set<String> set = new HashSet<>();
        int sum = nums1[0] + nums2[0];
        pq.add(new Node(sum, 0, 0));
        List<List<Integer>> output = new ArrayList<>();
        while (output.size() < k) {
            Node item = pq.poll();
            if (item.i + 1 < nums1.length && !set.contains(item.i + 1 + ":" + item.j)) {
                Node nextItemToPush = new Node(nums1[item.i + 1] + nums2[item.j], item.i + 1, item.j);
                pq.add(nextItemToPush);
            }
            if (item.j + 1 < nums2.length && !set.contains(item.i + ":" + item.j + 1)) {
                Node nextItemToPush = new Node(nums1[item.i] + nums2[item.j + 1], item.i, item.j + 1);
                pq.add(nextItemToPush);
            }
            List<Integer> minSum = new ArrayList<>();
            minSum.add(nums1[item.i]);
            minSum.add(nums2[item.j]);

            if (!set.contains(item.i+":"+item.j)) {
                set.add(item.i + ":" + item.j);
                output.add(minSum);
            }
        }
        return output;
    }


    public static void main(String[] args) {
        int nums1[] = {1, 2, 4, 5, 6};
        int nums2[] = {3, 5, 7, 9};
        int k = 20;
        System.out.println(new KPair().kSmallestPairs(nums1, nums2, k));
    }
}
