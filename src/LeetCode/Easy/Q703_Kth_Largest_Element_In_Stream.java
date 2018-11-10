package LeetCode.Easy;

import java.util.PriorityQueue;

public class Q703_Kth_Largest_Element_In_Stream {
    /**
     * Question :
     * Design a class to find the kth largest element in a stream. Note that it is
     * the kth largest element in the sorted order, not the kth distinct element.
     *
     * Your KthLargest class will have a constructor which accepts an integer k
     * and an integer array nums, which contains initial elements from the stream.
     * For each call to the method KthLargest.add, return the element representing
     * the kth largest element in the stream.
     *
     * Example :
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     */

    PriorityQueue<Integer> q;
    int k;

    public Q703_Kth_Largest_Element_In_Stream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
