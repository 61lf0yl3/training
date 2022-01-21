import java.util.Arrays;

class UniquePaths {
    // 62. Unique Paths

    // Approach 1: DP
    // Time Complexity: O(M*N)
    // Space Complexity: O(M*N)
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[n + 1][m + 1];
        paths[n][m] = 1;
        for (int r = 1; r < paths.length; r++) {
            for (int c = 1; c < paths[0].length; c++) {
                if (r == 2 && c == 1 || r == 1 && c == 2 || r == 1 && c == 1) {
                    paths[r][c] = 1;
                } else {
                    paths[r][c] = paths[r - 1][c] + paths[r][c - 1];
                }
            }
        }
        return paths[n][m];
    }

    // Approach 1: DP
    // Time Complexity: O(M*N)
    // Space Complexity: O(M*N)
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r > 0) {
                    dp[r][c] += dp[r - 1][c];
                }
                if (c > 0) {
                    dp[r][c] += dp[r][c - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // Approach 2: Recursion (Time limit exceeded)
    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    // Approach 2: DP Top-Down (Recursion with Memoization)
    // Time Complexity: O(M*N)
    // Space Complexity: O(M*N)
    int[][] memo;

    public int uniquePaths4(int m, int n) {
        memo = new int[m][n];
        return uniquePathsDP(m - 1, n - 1);
    }

    private int uniquePathsDP(int r, int c) {
        if (r + c == 0) {
            return 1;
        }
        if (memo[r][c] == 0) {
            int ways = 0;
            if (r > 0) {
                ways = uniquePathsDP(r - 1, c);
            }
            if (c > 0) {
                ways += uniquePathsDP(r, c - 1);
            }
            memo[r][c] = ways;
        }
        return memo[r][c];
    }

    // Approach 1: DP (leetcode version)
    // Time Complexity: O(M*N)
    // Space Complexity: O(M*N)
    public int uniquePaths3(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }

}