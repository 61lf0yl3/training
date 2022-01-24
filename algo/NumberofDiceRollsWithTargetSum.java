public class NumberofDiceRollsWithTargetSum {
    // Approach 2: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N*K)
    // Space Complexity: O(N*K)
    int k;
    Integer[][] memo;
    int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        this.k = k;
        memo = new Integer[n + 1][target + 1];
        return numRollsToTargetDP(n, target);
    }

    public int numRollsToTargetDP(int i, int sum) {
        if (i == 0 && sum == 0) {
            return 1;
        }
        if (i == 0 || sum <= 0) {
            return 0;
        }
        if (memo[i][sum] == null) {
            int r = 0;
            for (int j = 1; j <= k; j++) {
                r += numRollsToTargetDP(i - 1, sum - j);
                r %= MOD;
            }
            memo[i][sum] = r;
        }
        return memo[i][sum];
    }

    // Approach 2: DP Bottom-up
    // Time Complexity: O(N*K*T)
    // Space Complexity: O(N*K)
    public int numRollsToTarget2(int n, int k, int target) {
        int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int sum = target; sum > 0; sum--) {
                int r = 0;
                for (int j = 1; j <= Math.min(sum, k); j++) {
                    r += dp[i - 1][sum - j];
                    r %= MOD;
                }
                dp[i][sum] = r;
            }
        }
        return dp[n][target];
    }
}
