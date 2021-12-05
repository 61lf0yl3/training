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

    // Approach 2: Recursion (Time limit exceeded)
    public int uniquePaths2(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
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