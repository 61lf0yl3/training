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

    // Approach 3: DP Top-Down with Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[] memo;
    int k;

    public int numWays3(int n, int k) {
        this.k = k;
        memo = new int[n + 1];
        return numWaysDP(n);
    }

    public int numWaysDP(int i) {
        if (i == 1) {
            return k;
        }
        if (i == 2) {
            return k * k;
        }
        if (memo[i] == 0) {
            memo[i] = (k - 1) * (numWaysDP(i - 1) + numWaysDP(i - 2));
        }
        return memo[i];
    }
}