import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElementinanArray {
    // 215. Kth Largest Element in an Array

    // Approach 1: PriorityQueue
    // Time Complexity: O(N)
    // Space Complexity: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qp = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            qp.add(nums[i]);
            if (qp.size() > k) {
                qp.remove();
            }
        }
        return qp.poll();
    }

    // Approach 3: Sort
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}