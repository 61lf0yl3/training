import java.util.Queue;
import java.util.LinkedList;

class Solution {

    // Approach 1: BFS
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[] { r, c });
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                int r = point[0];
                int c = point[1];
                for (int[] direction : directions) {
                    int newR = r + direction[0];
                    int newC = c + direction[1];
                    if (newR >= 0 && newC >= 0 && newR < n && newC < m && grid[newR][newC] == 1) {
                        q.add(new int[] { newR, newC });
                        grid[newR][newC] = 2;
                        fresh--;
                    }
                }
            }
            if (!q.isEmpty()) {
                res++;
            }
        }
        return fresh == 0 ? res : -1;
    }
}