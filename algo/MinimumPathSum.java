import java.util.Arrays;

class MinimumPathSum {
    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    int[][] memo;
    int[][] grid;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int r = 0; r < m; r++) {
            Arrays.fill(memo[r], Integer.MAX_VALUE);
        }
        memo[0][0] = grid[0][0];
        return minPathSumDP(m - 1, n - 1);
    }

    private int minPathSumDP(int r, int c) {
        int[][] memo1 = memo;
        if (memo[r][c] == Integer.MAX_VALUE) {
            int sum1 = Integer.MAX_VALUE;
            int sum2 = Integer.MAX_VALUE;
            if (r > 0) {
                sum1 = minPathSumDP(r - 1, c);
            }
            if (c > 0) {
                sum2 = minPathSumDP(r, c - 1);
            }
            memo[r][c] = grid[r][c] + Math.min(sum1, sum2);
        }
        return memo[r][c];
    }

    // Approach 1: DP Bottom-Up (Recursion with memorazation);
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int sum1 = Integer.MAX_VALUE;
                int sum2 = Integer.MAX_VALUE;
                if (r > 0) {
                    sum1 = dp[r - 1][c];
                }
                if (c > 0) {
                    sum2 = dp[r][c - 1];
                }
                if (r != 0 || c != 0) {
                    dp[r][c] = grid[r][c] + Math.min(sum1, sum2);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}