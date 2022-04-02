import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;

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

    // Approach 2: DFS
    // Time complexity : O(|x|*|y|)
    // Space complexity : O(|x|*|y|)
    private HashMap<String, Integer> memo;

    private int dp(int x, int y) {
        String key = x + "," + y;
        if (x == 0 && y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        } else if (!memo.containsKey(key)) {
            int res = Math.min(dp(Math.abs(x - 1), Math.abs(y - 2)),
                    dp(Math.abs(x - 2), Math.abs(y - 1))) + 1;
            memo.put(key, res);

        }
        return memo.get(key);
    }

    public int minKnightMoves2(int x, int y) {
        memo = new HashMap<>();
        return dp(x, y);
    }
}