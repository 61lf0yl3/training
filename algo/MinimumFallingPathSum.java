class MinimumFallingPathSum {
    // Approach 1: DP Bottom-Up
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int res = Integer.MAX_VALUE;
        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int num1 = Integer.MAX_VALUE;
                int num2 = matrix[r - 1][c];
                int num3 = Integer.MAX_VALUE;
                if (c > 0) {
                    num1 = matrix[r - 1][c - 1];
                }
                if (c < n - 1) {
                    num3 = matrix[r - 1][c + 1];
                }
                matrix[r][c] += Math.min(num2, Math.min(num1, num3));
                if (r == n - 1) {
                    res = Math.min(res, matrix[r][c]);
                }
            }
        }
        return res;
    }
}