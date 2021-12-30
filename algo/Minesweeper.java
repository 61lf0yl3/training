import java.util.ArrayDeque;
import java.util.Queue;

class Minesweeper {
    // 529. Minesweeper

    // Approach 1: BFS
    // Time complexity : O(N*K)
    // Space complexity : O(N*K)
    int[][] neighbor = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
            { 1, 1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(click);
        while (!q.isEmpty()) {
            bfs(board, q);
        }
        return board;
    }

    public void bfs(char[][] board, Queue<int[]> q) {
        int[] point = q.poll();
        int x = point[0];
        int y = point[1];
        int numMine = 0;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        for (int i = 0; i < neighbor.length; i++) {
            int newX = x + neighbor[i][0];
            int newY = y + neighbor[i][1];
            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length ||
                    board[newX][newY] == 'B') {
                continue;
            }
            if (board[newX][newY] == 'M' || board[newX][newY] == 'X') {
                numMine++;
            }
        }
        if (numMine > 0) {
            board[x][y] = Integer.toString(numMine).charAt(0);
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < neighbor.length; i++) {
                int newX = x + neighbor[i][0];
                int newY = y + neighbor[i][1];
                if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length ||
                        board[newX][newY] == 'B') {
                    continue;
                }
                if (board[newX][newY] == 'E') {
                    board[newX][newY] = 'B';
                }
                q.add(new int[] { newX, newY });
            }
        }
    }
}