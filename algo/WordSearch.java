class WordSearch {
    //Approach 1: DFS
    //Time Complexity: O(N*3^L)
    //Space Complexity: O(L)
    //L is the length of the word to be matched
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

    //Approach 1: DFS
    //Time Complexity: O(N*3^L)
    //Space Complexity: O(L)
    //L is the length of the word to be matched
class WordSearch2 {
    private char[][] board;
    private int ROWS;
    private int COLS;
  
    public boolean exist(char[][] board, String word) {
      this.board = board;
      this.ROWS = board.length;
      this.COLS = board[0].length;
  
      for (int row = 0; row < this.ROWS; ++row)
        for (int col = 0; col < this.COLS; ++col)
          if (this.backtrack(row, col, word, 0))
            return true;
      return false;
    }
  
    protected boolean backtrack(int row, int col, String word, int index) {
      /* Step 1). check the bottom case. */
      if (index >= word.length())
        return true;
  
      /* Step 2). Check the boundaries. */
      if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
          || this.board[row][col] != word.charAt(index))
        return false;
  
      /* Step 3). explore the neighbors in DFS */
      boolean ret = false;
      // mark the path before the next exploration
      this.board[row][col] = '#';
  
      int[] rowOffsets = {0, 1, 0, -1};
      int[] colOffsets = {1, 0, -1, 0};
      for (int d = 0; d < 4; ++d) {
        ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
        if (ret)
          break;
      }
  
      /* Step 4). clean up and return the result. */
      this.board[row][col] = word.charAt(index);
      return ret;
    }
  }
  
  