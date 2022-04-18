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
        int res = 0;
        int[] dp = new int[matrix[0].length + 1];
        int prev = 0;
        for (int r = 1; r <= matrix.length; r++) {
            for (int c = 1; c <= matrix[0].length; c++) {
                int temp = dp[c];
                if (matrix[r - 1][c - 1] == '1') {
                    dp[c] = 1 + Math.min(dp[c - 1], Math.min(dp[c], prev));
                    res = Math.max(res, dp[c]);
                } else {
                    dp[c] = 0;
                }
                prev = temp;
            }
        }
        return res * res;
    }
}