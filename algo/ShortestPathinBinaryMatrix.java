import java.util.Queue;
import java.util.LinkedList;

class ShortestPathinBinaryMatrix {

    // Approach 1: Breadth-first Search (BFS), Overwriting Input
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        grid[0][0] = 1;
        if (n > 1) {
            grid[n - 1][n - 1] = -1;
        }
        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            for (int[] direction : directions) {
                int newR = r + direction[0];
                int newC = c + direction[1];
                if (newR >= 0 && newC >= 0 && newR < n && newC < n && grid[newR][newC] <= 0) {
                    q.add(new int[] { newR, newC });
                    grid[newR][newC] = grid[r][c] + 1;
                }
            }
        }
        return grid[n - 1][n - 1];
    }
}