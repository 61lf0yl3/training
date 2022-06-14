import java.util.Queue;
import java.util.LinkedList;

public class WallsandGates {
    // Approach#2(Breadth-first Search)
    // Time Complexity: O(NM)
    // Space Complexity: O(NM)
    private final int GATE = 0;
    private final int EMPTY = Integer.MAX_VALUE;
    private final int[][] DIRECTIONS = new int[][] { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public void wallsAndGates(int[][] rooms) {

        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rooms[r][c] == GATE) {
                    q.add(new int[] { r, c });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int r = pair[0];
            int c = pair[1];
            for (int[] d : DIRECTIONS) {
                int newR = r + d[0];
                int newC = c + d[1];
                if (newR < 0 || newC < 0 || newR >= n || newC >= m ||
                        rooms[newR][newC] != EMPTY) {
                    continue;
                }
                rooms[newR][newC] = rooms[r][c] + 1;
                q.add(new int[] { newR, newC });

                // if (newR >= 0 && newC >= 0 && newR < n && newC < m && rooms[newR][newC] ==
                // Integer.MAX_VALUE) {
                // rooms[newR][newC] = rooms[r][c] + 1;
                // q.add(new int[] { newR, newC });
                // }
            }
        }
    }
}
