class SlidingWindowMaximum {
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