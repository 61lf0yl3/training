import java.util.ArrayDeque;

class SlidingWindowMaximum {

    // Approach 1: DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < nums.length; i++) {
            // from left to right
            if (i % k == 0) { // block_start
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            int j = n - i - 1;
            if (j % k == 0) { // block_start
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }

    // Approach 1: Using Deque
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[] nums;
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

    public int[] maxSlidingWindow2(int[] nums, int k) {

        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1)
            return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    private void cleanDeque(int i, int k) {

        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    // Approach 3: Brute Force (Hammer)
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

}