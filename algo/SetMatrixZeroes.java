class SetMatrixZeroes {
    // Approach 1: O(1) Space, Efficient Solution
    // Time Complexity: O(N*M)
    // Space Complexity: O(1)
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        for (int i = 0; i < matrix.length; i++) {
            // Since first cell for both first row and first column is the same i.e.
            // matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                // If an element is zero, we set the first element of the corresponding row and
                // column to 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column,
        // update the elements.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            matrix[0] = new int[matrix[0].length];
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}