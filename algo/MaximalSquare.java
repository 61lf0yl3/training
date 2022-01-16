class MaximalSquare {
    // Approach 1: DP Bottom-Up
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] memo = new int[n + 1][m + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    memo[i][j] = 1 + Math.min(memo[i - 1][j - 1], Math.min(
                            memo[i - 1][j], memo[i][j - 1]));
                    res = Math.max(res, memo[i][j]);
                }
            }
        }
        return res * res;
    }

    // Approach 2: DP Bottom-Up to Memory Optimazation
    // Time Complexity: O(N*M)
    // Space Complexity: O(M)
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
}