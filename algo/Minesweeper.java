import java.util.Queue;
import java.util.LinkedList;

class Minesweeper {
    // 529. Minesweeper

    // Approach 1: BFS
    // Time complexity : O(N*K)
    // Space complexity : O(N*K)
    int[][] neighbors = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        while (!q.isEmpty()) {
            bfs(board, q);
        }
        return board;
    }

    private void bfs(char[][] board, Queue<int[]> q) {
        int[] point = q.poll();
        int x = point[0];
        int y = point[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        int numMines = 0;
        for (int[] neighbor : neighbors) {
            int newX = x + neighbor[0];
            int newY = y + neighbor[1];
            if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length) {
                if (board[newX][newY] == 'M' || board[newX][newY] == 'X') {
                    numMines++;
                }
            }
        }
        if (numMines > 0) {
            board[x][y] = (char) (numMines + '0');
        } else {
            board[x][y] = 'B';
            for (int[] neighbor : neighbors) {
                int newX = x + neighbor[0];
                int newY = y + neighbor[1];
                if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length) {
                    if (board[newX][newY] == 'E') {
                        board[newX][newY] = 'B';
                        q.add(new int[] { newX, newY });
                    }
                }
            }
        }
    }
}