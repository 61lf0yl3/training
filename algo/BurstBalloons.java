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

        memo = new int[n][n];

        return dp(1, n - 2);
    }

    private int dp(int left, int right) {
        if (right - left < 0) {
            return 0;
        }
        if (memo[left][right] == 0) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                int remaining = dp(left, i - 1) + dp(i + 1, right);
                res = Math.max(res, remaining + gain);
            }
            memo[left][right] = res;
        }
        return memo[left][right];
    }
}