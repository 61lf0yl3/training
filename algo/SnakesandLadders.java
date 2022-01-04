import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class SnakesandLadders {
    // 909. Snakes and Ladders

    // Approach 1: BFS
    // Time complexity : O(MN)
    // Space complexity : O(MN)
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = board.length;

        int key = 1;
        boolean flag = true;
        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        m.put(key, board[i][j]);
                    }
                    key++;
                }
                flag = false;
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        m.put(key, board[i][j]);
                    }
                    key++;
                }
                flag = true;
            }
        }

        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new ArrayDeque();
        int moves = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                int curr = q.poll();
                if (curr == n * n) {
                    return moves;
                }
                if (seen.contains(curr)) {
                    continue;
                }
                seen.add(curr);

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int boardCurr = m.getOrDefault(next, next);
                    if (!seen.contains(boardCurr)) {
                        q.add(boardCurr);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}

/*
 * private void dfs(int curr, int moves) {
 * if (curr == n*n) {
 * res = Math.min(res, moves);
 * return;
 * }
 * if (seen.contains(curr)) {
 * return;
 * }
 * seen.add(curr);
 * if (m.get(curr)!=-1) {
 * dfs(m.get(curr), moves);
 * }
 * for (int i = curr+1; i <= Math.min(curr+6, n*n); i++) {
 * dfs(i, moves+1);
 * }
 * }
 */