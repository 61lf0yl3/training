import java.util.ArrayList;
import java.util.Collections;

public class DiagonalTraverse {
    // 498. Diagonal Traverse

    // Approach 1: Diagonal Iteration and Reversal
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] res = new int[n * m];
        int i = 0;
        for (int d = 0; d < n + m - 1; d++) {
            int r = d < m ? 0 : d - m + 1;
            int c = d < m ? d : m - 1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (r < n && c >= 0) {
                temp.add(mat[r++][c--]);
            }
            if (d % 2 == 0) {
                for (int j = temp.size() - 1; j >= 0; j--) {
                    res[i++] = temp.get(j);
                }
            } else {
                for (int num : temp) {
                    res[i++] = num;
                }
            }
        }
        return res;
    }

    // Approach 2: Simulation
    // Time Complexity: O(N*M)
    // Space Complexity: O(1)
    public int[] findDiagonalOrder2(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N * M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0);
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }
}
