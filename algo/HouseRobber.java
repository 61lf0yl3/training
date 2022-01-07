class HouseRobber {
    // 198. House Robber

    // Approach 1: DP Optimized
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int rob(int[] nums) {
        int res = 0;
        int n = nums.length;
        int oldest = 0;
        int old = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = nums[i];
            int prevRes = res;
            res = Math.max(res, Math.max(curr + old, curr + oldest));
            oldest = old;
            old = prevRes;
        }
        return res;
    }

}