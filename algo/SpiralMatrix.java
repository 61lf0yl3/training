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

}
