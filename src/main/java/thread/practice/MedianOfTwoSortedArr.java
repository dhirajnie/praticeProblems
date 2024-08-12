package thread.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArr {

    /*
    1234 12


     */

    void addInthePQ(PriorityQueue<Integer> minQeue, PriorityQueue<Integer> maxQeue, int item) {
        if (maxQeue.size() == 0) {
            maxQeue.add(item);
        } else if (maxQeue.peek() < item) {
            minQeue.add(item);
        } else {
            minQeue.add(maxQeue.poll());
            maxQeue.add(item);
        }
        if (minQeue.size() > maxQeue.size()) {
            maxQeue.add(minQeue.poll());
        } else if (maxQeue.size() > minQeue.size() + 1) {
            minQeue.add(maxQeue.poll());
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int i = 0; i < nums1.length; i++) {
            addInthePQ(minHeap, maxHeap, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            addInthePQ(minHeap, maxHeap, nums2[i]);
        }
        System.out.println("MaxHeap:" + maxHeap);
        System.out.println("MinHeap:" + minHeap);

        if (maxHeap.size() > minHeap.size()) {
            return new Double(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            return new Double(minHeap.poll());
        } else {
            return (double) (maxHeap.poll() + minHeap.poll()) / 2;
        }

    }

    public static void main(String[] args) {
        int num1[] = {3, 4, 5, 6};
        int num2[] = {1, 2};
        System.out.println(new MedianOfTwoSortedArr().findMedianSortedArrays(num1, num2));
    }
}
