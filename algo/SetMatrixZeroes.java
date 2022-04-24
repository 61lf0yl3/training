class SetMatrixZeroes {
    // Approach 1: O(1) Space, Efficient Solution
    // Time Complexity: O(N*M)
    // Space Complexity: O(1)
    public void setZeroes(int[][] matrix) {
        boolean isColZero = false;
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {
                isColZero = true;
            }
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            matrix[0] = new int[matrix[0].length];
        }
        if (isColZero) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}