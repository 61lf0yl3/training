public class DesignTicTacToe {
    public static void main(String[] args) {

    }
}

// Approach 1: Optimized Brute Force
// Time Complexity: O(N)
// Space Complexity: O(N)
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
                checkCol(row, col, player) ||
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

    private boolean checkCol(int row, int col, int player) {
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

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
