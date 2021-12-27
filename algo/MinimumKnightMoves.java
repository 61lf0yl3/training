import java.util.Queue;
import java.util.ArrayDeque;

class MinimumKnightMoves {

    // Approach 1: BFS
    // Time complexity : O((max(|x|,|y|))^2)
    // Space complexity : O((max(|x|,|y|))^2)
    public int minKnightMoves(int x, int y) {
        int[][] knightMoves = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 },
                { -1, 2 } };
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0 });
        boolean[][] seen = new boolean[607][607];
        // Set<int[]> seen = new HashSet<>();
        int step = 0;
        while (!q.isEmpty()) {
            int currLevelSize = q.size();

            for (int i = 0; i < currLevelSize; i++) {
                int[] curr = q.poll();
                if (curr[0] == x && curr[1] == y) {
                    return step;
                }
                for (int[] move : knightMoves) {
                    int[] next = new int[] { curr[0] + move[0], curr[1] + move[1] };
                    // if (!seen.contains(next)) {
                    // seen.add(next);
                    // q.add(next);
                    // }
                    if (!seen[next[0] + 302][next[1] + 302]) {
                        seen[next[0] + 302][next[1] + 302] = true;
                        q.add(next);
                    }
                }
            }
            step++;
        }
        return step;
    }
}