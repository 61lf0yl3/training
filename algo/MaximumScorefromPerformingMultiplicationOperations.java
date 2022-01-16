class MaximumScorefromPerformingMultiplicationOperations {
    int[] nums;
    int[] multipliers;
    int[][] memo;
    int n;
    int m;

    // Approach 2: DP Bottom-Up
    // Time Complexity: O(M^2)
    // Space Complexity: O(M^2)
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                } else {
                    memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
                }
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