class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                //boolean[][] seen = new boolean[board.length][board[0].length];
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, new boolean[board.length][board[0].length], r, c, 0,0,0)) {
                        res = true;
                    }
                }
            }
        }
        return res;
    }

    public boolean dfs(char[][] board, String word, boolean[][] seen, int r, int c, int index, int prevR, int prevC) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return false;
        }
        if (!seen[r][c] && board[r][c] == word.charAt(index)) {
            seen[r][c] =true;
            boolean res = dfs(board, word, seen, r + 1, c, index + 1, r, c) 
                || dfs(board, word, seen, r - 1, c, index + 1, r, c)
                || dfs(board, word, seen, r, c + 1, index + 1, r, c)
                || dfs(board, word, seen, r, c - 1, index + 1, r, c);
            seen[r][c] =false;
            return res;
        }
        return false;
    }
}