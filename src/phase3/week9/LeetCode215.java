package phase3.week9;

import java.util.PriorityQueue;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {

        MinHeap<Integer> pq = new MinHeap<>();
        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        for (int i = k; i < nums.length; i++)
            if (!pq.isEmpty() && nums[i] > pq.findMin())
                pq.replace(nums[i]);

        return pq.findMin();
    }

    //使用Java中的PriorityQueue
    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        for (int i = k; i < nums.length; i++)
            if (!pq.isEmpty() && nums[i] > pq.peek()) {
                pq.remove(nums[i]);
                pq.add(nums[i]);
            }

        return pq.peek();
    }

}
