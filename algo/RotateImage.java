class RotateImage {
    // 48. Rotate Image

    // Approach 1: Reverse on Diagonal and then Reverse Left to Right
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n - 1 - c];
                matrix[r][n - 1 - c] = temp;
            }
        }
    }
}