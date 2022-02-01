class CombinationSum4 {
    // Approach 2: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)
    Integer[] memo;
    int target;
    int[] nums;

    public int combinationSum4(int[] nums, int target) {
        memo = new Integer[target + 1];
        this.nums = nums;
        this.target = target;
        return DP(target);
    }

    private int DP(int remain) {
        Integer[] memo1 = memo;
        if (remain == 0) {
            return 1;
        }
        if (memo[remain] == null) {
            int best = 0;
            for (int nb : nums) {
                if (nb <= remain) {
                    best += DP(remain - nb);
                }
            }
            memo[remain] = best;
        }
        return memo[remain];
    }

    // Approach 2: DP Borrom-Up
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)
    public int combinationSum42(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 1;
        for (int remain = 1; remain <= target; remain++) {
            int best = 0;
            for (int nb : nums) {
                if (nb <= remain) {
                    best += dp[remain - nb];
                }
            }
            dp[remain] = best;
        }
        return dp[target];
    }
}