class MaximumScorefromPerformingMultiplicationOperations {
    int[] nums;
    int[] multipliers;
    int[][] memo;
    int n;
    int m;

    // Approach 2: DP Bottom-Up
    // Time Complexity: O(M^2)
    // Space Complexity: O(M^2)
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] memo = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int mult = multipliers[i];
                int right = n - 1 - (i - left);
                memo[i][left] = Math.max(nums[left] * mult + memo[i + 1][left + 1],
                        nums[right] * mult + memo[i + 1][left]);
            }
        }

        return memo[0][0];
    }

    // Approach 2: DP Top-Down
    // Time Complexity: O(M^2)
    // Space Complexity: O(M^2)
    public int maximumScore2(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        memo = new int[m][m];
        return maximumScoreDP(0, 0);
    }

    public int maximumScoreDP(int i, int left) {
        if (i >= m) {
            return 0;
        }
        int mult = multipliers[i];
        int right = n - 1 - (i - left);
        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(mult * nums[left] + maximumScoreDP(i + 1, left + 1),
                    mult * nums[right] + maximumScoreDP(i + 1, left));
        }
        return memo[i][left];
    }
}