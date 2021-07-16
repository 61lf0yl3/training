class MaximumSubarray {
    // 53. Maximum Subarray

    // Approach 1: Dynamic Programming, Kadane's Algorithm
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr += nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            if (curr < nums[i]) {
                curr = nums[i];
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    // Approach 3: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int maxSubArray3(int[] nums) {
        int res = nums[0];
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}