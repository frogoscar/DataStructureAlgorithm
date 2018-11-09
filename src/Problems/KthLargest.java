package Problems;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
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
