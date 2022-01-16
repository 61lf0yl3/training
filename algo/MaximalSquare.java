class MaximalSquare {
    // Approach 2: DP Bottom-Up
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
}