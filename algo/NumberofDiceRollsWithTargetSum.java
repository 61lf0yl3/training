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
}
