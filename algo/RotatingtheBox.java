public class RotatingtheBox {
    // Approach 1: Iterative Rotate+Down
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] res = new char[m][n];
        for (int c = 0; c < m; c++) {
            for (int r = n - 1; r >= 0; r--) {
                res[c][n - 1 - r] = box[r][c];
            }
        }
        for (int c = 0; c < n; c++) {
            int rowDown = 0;
            for (int r = m - 1; r >= 0; r--) {
                if (res[r][c] == '.') {
                    rowDown++;
                } else if (res[r][c] == '*') {
                    rowDown = 0;
                } else if (rowDown > 0) {
                    res[r + rowDown][c] = res[r][c];
                    res[r][c] = '.';
                }
            }
        }
        return res;
    }
}
