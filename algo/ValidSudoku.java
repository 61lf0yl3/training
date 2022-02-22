import java.util.HashSet;
import java.util.Set;

class ValidSudoku {

    // Approach 1: Using HashSet
    // Time Complexity: O(N^2)
    // Space Complexity: O(N^2)
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int r = 0; r < n; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char ch = board[r][c];
                // Check if the position is filled with number
                if (ch == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(ch)) {
                    return false;
                }
                rows[r].add(ch);

                // Check the column
                if (cols[c].contains(ch)) {
                    return false;
                }
                cols[c].add(ch);

                // Check the box
                int i = (r / 3) * 3 + c / 3;
                if (boxes[i].contains(ch)) {
                    return false;
                }
                boxes[i].add(ch);
            }
        }
        return true;
    }

}