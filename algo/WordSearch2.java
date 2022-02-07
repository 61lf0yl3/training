import java.util.ArrayList;
import java.util.List;

class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0
                || board[row][col] != word.charAt(index)) {
            return false;
        }
        board[row][col] = '1';
        boolean ret = dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1)
                || dfs(board, word, row + 1, col, index + 1)
                || dfs(board, word, row, col - 1, index + 1);
        board[row][col] = word.charAt(index);
        return ret;
    }
}