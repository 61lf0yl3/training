class GameofLife {
    // 289. Game of Life

    // Approach 1: O(mn) Space Solution
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    int[][] neighbors = new int[][] { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 },
            { 1, 1 } };

    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, copy, r, c);
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = copy[r][c];
            }
        }
    }

    public void dfs(int[][] board, int[][] copy, int row, int col) {
        int liveCell = 0;
        for (int i = 0; i < neighbors.length; i++) {
            int newRow = row + neighbors[i][0];
            int newCol = col + neighbors[i][1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                    && board[newRow][newCol] == 1) {
                liveCell++;
            }
        }
        if (board[row][col] == 1) {
            // lives on to the next generation
            if (liveCell == 2 || liveCell == 3) {
                copy[row][col] = 1;
            }
        } else {
            if (liveCell == 3) {
                copy[row][col] = 1;
            }
        }
    }
}