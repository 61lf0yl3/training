class UniquePaths2 {

    // Approach 1: DP Bottom-Up
    // Time Complexity: O(M*N)
    // Space Complexity: O(M*N)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] == 0) {
                    if (r > 0 && obstacleGrid[r - 1][c] == 0) {
                        dp[r][c] += dp[r - 1][c];
                    }
                    if (c > 0 && obstacleGrid[r][c - 1] == 0) {
                        dp[r][c] += dp[r][c - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // Approach 1: DP Bottom-Up
    // Time Complexity: O(M*N)
    // Space Complexity: O(1)
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = -1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] != 1) {
                    if (r > 0) {
                        obstacleGrid[r][c] += -Math.abs(obstacleGrid[r - 1][c]);
                    }
                    if (c > 0) {
                        obstacleGrid[r][c] += -Math.abs(obstacleGrid[r][c - 1]);
                    }
                } else {
                    obstacleGrid[r][c] = 0;
                }
            }
        }
        return Math.abs(obstacleGrid[m - 1][n - 1]);
    }
}