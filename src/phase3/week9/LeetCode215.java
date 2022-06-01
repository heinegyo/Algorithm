package phase3.week9;

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
}
