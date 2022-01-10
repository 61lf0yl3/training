class CandyCrush {
    // 723. Candy Crush

    // Approach 1: Ad-Hoc
    // Time Complexity: O((R*C)^2)
    // Space Complexity: O(1)
    public int[][] candyCrush(int[][] board) {
        if (crush(board)) {
            gravity(board);
            return candyCrush(board);
        } else {
            return board;
        }
    }

    private boolean crush(int[][] board) {
        boolean hasChange = false;
        // crusing
        for (int r = 0; r < board.length; r++) {
            for (int c = 2; c < board[0].length; c++) {
                int candyType = Math.abs(board[r][c]);
                if (candyType != 0 && candyType == Math.abs(board[r][c - 1])
                        && candyType == Math.abs(board[r][c - 2])) {
                    board[r][c] = -candyType;
                    board[r][c - 1] = -candyType;
                    board[r][c - 2] = -candyType;
                    hasChange = true;
                }
            }
        }

        for (int c = 0; c < board[0].length; c++) {
            for (int r = 2; r < board.length; r++) {
                int candyType = Math.abs(board[r][c]);
                if (candyType != 0 && candyType == Math.abs(board[r - 1][c])
                        && candyType == Math.abs(board[r - 2][c])) {
                    board[r][c] = -candyType;
                    board[r - 1][c] = -candyType;
                    board[r - 2][c] = -candyType;
                    hasChange = true;
                }
            }
        }
        return hasChange;
    }

    private void gravity(int[][] board) {
        for (int c = 0; c < board[0].length; c++) {
            int newR = board.length - 1;
            for (int r = board.length - 1; r >= 0; r--) {
                if (board[r][c] > 0) {
                    board[newR--][c] = board[r][c];
                }
            }
            while (newR >= 0) {
                board[newR--][c] = 0;
            }
        }
    }
}