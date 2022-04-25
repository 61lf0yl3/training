class Searcha2DMatrix {
    // 74. Search a 2D Matrix

    // Approach : Binary Search
    // Time Complexity:O(logN+logM)
    // Space Complexity: O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int temp = matrix[mid / m][mid % m];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // Approach : Binary Search
    // Time Complexity:O(logN+logM)
    // Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = bSearchRow(matrix, target);
        if (rowIndex != -1) {
            if (bSearchCol(matrix[rowIndex], target)) {
                return true;
            }
        }
        return false;
    }

    public int bSearchRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int lastIndex = matrix[mid].length - 1;
            if (matrix[mid][0] <= target && matrix[mid][lastIndex] >= target) {
                return mid;
            } else if (matrix[mid][lastIndex] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public boolean bSearchCol(int[] matrixRow, int target) {
        int low = 0;
        int high = matrixRow.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrixRow[mid] == target) {
                return true;
            } else if (matrixRow[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}