class MaximumProductSubarray {
    // Approach 1: DP
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            max = temp;
            res = Math.max(res, Math.max(max, min));
        }
        return res;
    }
}