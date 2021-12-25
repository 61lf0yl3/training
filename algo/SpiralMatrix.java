import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    // Approach #1: DFS
    // Time Complexity: O(MN)
    // Space Complexity: O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        dfs(matrix, res, 0, 0);
        return res;
    }

    public void dfs(int[][] matrix, List<Integer> res, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0 || matrix[row][col] == 101) {
            return;
        } else {
            res.add(matrix[row][col]);
            matrix[row][col] = 101;
            // right
            if (row - 1 < 0 || matrix[row - 1][col] == 101) {
                dfs(matrix, res, row, col + 1);
            }

            // down
            dfs(matrix, res, row + 1, col);

            // left
            dfs(matrix, res, row, col - 1);

            // up
            dfs(matrix, res, row - 1, col);
        }
    }

    // Approach 2: Set Up Boundaries
    // Time Complexity: O(MN)
    // Space Complexity: O(1)
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (result.size() < rows * columns) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                result.add(matrix[up][col]);
            }
            // Traverse downwards.
            for (int row = up + 1; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            // Make sure we are now on a different row.
            if (up != down) {
                // Traverse from right to left.
                for (int col = right - 1; col >= left; col--) {
                    result.add(matrix[down][col]);
                }
            }
            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return result;
    }
}
