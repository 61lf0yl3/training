class BurstBalloons {
    // Approach 1: Dynamic Programming (Top-Down)
    // Time Complexity: O(N^3)
    // Space Complexity: O(N^2)
    int[][] memo;
    int[] newNums;

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;

        // cache the results of dp
        memo = new int[n][n];

        // we can not burst the first one and the last one
        // since they are both fake balloons added by ourselves
        return dp(1, n - 2);
    }

    private int dp(int left, int right) {
        // return maximum if we burst all nums[left]...nums[right], inclusive
        if (right - left < 0) {
            return 0;
        }
        // we've not seen this, write for cache
        if (memo[left][right] == 0) {
            // find the last burst one in nums[left]...nums[right]
            int res = 0;
            for (int i = left; i <= right; i++) {
                // nums[i] is the last burst one
                int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                // nums[i] is fixed, recursively call left side and right side
                int remaining = dp(left, i - 1) + dp(i + 1, right);
                res = Math.max(res, remaining + gain);
            }
            // add to the cache
            memo[left][right] = res;
        }
        return memo[left][right];
    }

    // Approach 2: Dynamic Programming (Bottom-Up)
    // Time Complexity: O(N^3)
    // Space Complexity: O(N^2)
    public int maxCoins2(int[] nums) {
        // add 1 before and after nums
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        // dp[i][j] represents
        // maximum if we burst all nums[left]...nums[right], inclusive
        int[][] dp = new int[n][n];

        // do not include the first one and the last one
        // since they are both fake balloons added by ourselves and we can not burst
        // them
        for (int left = n - 2; left >= 1; left--) {
            for (int right = left; right <= n - 2; right++) {
                // find the last burst one in newNums[left]...newNums[right]
                for (int i = left; i <= right; i++) {
                    // newNums[i] is the last burst one
                    int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                    // recursively call left side and right side
                    int remaining = dp[left][i - 1] + dp[i + 1][right];
                    // update
                    dp[left][right] = Math.max(dp[left][right], remaining + gain);
                }
            }
        }
        // burst newNums[1]...newNums[n-2], excluding the first one and the last one
        return dp[1][n - 2];
    }
}