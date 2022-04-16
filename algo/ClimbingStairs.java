class ClimbingStairs {
    // 70. Climbing Stairs

    // Approach 1: DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n == 1) {
            return dp[n];
        }
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    int[] memo;
    int n;

    public int climbStairs2(int n) {
        this.n = n;
        memo = new int[n + 1];
        return dp(n);
    }

    public int dp(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (memo[i] == 0) {
            memo[i] = dp(i - 1) + dp(i - 2);
        }
        return memo[i];
    }
}