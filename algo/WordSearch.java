class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        boolean res = true;
        for (int r=0; r< board.length; r++) {
            for (int c=0; c< board[0].length; c++) {
                if (board[r][c]==word.charAt(0)) {
                    res = dfs(board, word, seen,r,c,0);
                }
            }
        }
        return res;
    }
                
    
    public boolean dfs(char[][] board, String word, boolean[][] seen, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        } else if (!seen[r][c] && board[r][c]==word.charAt(index)) {
            if (r >0 && c > 0 &&
                   r < board.length-1 && c < board.length-1) {
            seen[r][c]=true;
            return dfs(board, word, seen,r+1,c,index+1) || dfs(board, word, seen,r-1,c,index+1) || dfs(board, word, seen,r,c+1,index+1) || dfs(board, word, seen,r,c-1,index+1);
        }
        return false;
        }
    }
}