class WordSearch {
  // Approach 1: DFS
  // Time Complexity: O(N*3^L)
  // Space Complexity: O(L)
  // L is the length of the word to be matched
  char[][] board;
  String word;
  boolean[][] memo;
  int n;
  int m;

  public boolean exist(char[][] board, String word) {
    this.board = board;
    this.word = word;
    this.n = board.length;
    this.m = board[0].length;
    this.memo = new boolean[n][m];
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < m; c++) {
        if (board[r][c] == word.charAt(0)) {
          if (dfs(r, c, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs(int r, int c, int i) {
    if (i >= word.length()) {
      return true;
    }
    if (r >= n || c >= m || r < 0 || c < 0 || memo[r][c] || board[r][c] != word.charAt(i)) {
      return false;
    }
    memo[r][c] = true;
    boolean res = dfs(r - 1, c, i + 1) || dfs(r, c - 1, i + 1) || dfs(r + 1, c, i + 1) || dfs(r, c + 1, i + 1);
    memo[r][c] = false;
    return res;
  }
}

// Approach 1: DFS
// Time Complexity: O(N*3^L)
// Space Complexity: O(L)
// L is the length of the word to be matched
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

    int[] rowOffsets = { 0, 1, 0, -1 };
    int[] colOffsets = { 1, 0, -1, 0 };
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
