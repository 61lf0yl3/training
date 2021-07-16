class MaximumSubarray {
    // 53. Maximum Subarray

    // Approach 3: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
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