public class DesignTicTacToe {
    public static void main(String[] args) {

    }
}

// Approach 1: Optimized Brute Force
// Time Complexity: O(N)
// Space Complexity: O(N^2)
class TicTacToe {

    private int n;
    private int[][] board;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];

    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(row, player) ||
                checkCol(col, player) ||
                (row == col && checkDiagonal(player)) ||
                (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int num : board[row]) {
            if (num != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int r = 0; r < n; r++) {
            if (board[r][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != player) {
                return false;
            }
        }
        return true;
    }
}

// Approach 1: Optimised Approach
// Time Complexity: O(1)
// Space Complexity: O(N)
class TicTacToe2 {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDdiagonal;
    private int n;

    public TicTacToe2(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDdiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int curr = (player == 1) ? 1 : -1;
        rows[row] += curr;
        cols[col] += curr;

        if (row == col) {
            diagonal += curr;
        }
        if (col == n - 1 - row) {
            antiDdiagonal += curr;
        }

        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDdiagonal) == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
