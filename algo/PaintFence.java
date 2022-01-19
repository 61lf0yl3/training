class PaintFence {
    // Approach 1: DP Bottom-Up (Tabulation) Constant Space
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        int oldest = k;
        int old = k * k;
        for (int i = 3; i <= n; i++) {
            int curr = (k - 1) * (oldest + old);
            oldest = old;
            old = curr;
        }
        return old;
    }

    // Approach 2: DP Bottom-Up (Tabulation)
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int numWays2(int n, int k) {
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}