class PaintHouse {
    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[][] costs;
    Integer[][] memo;

    public int minCost(int[][] costs) {
        this.costs = costs;
        memo = new Integer[costs.length][4];
        return minCostDP(0, 3);
    }

    private int minCostDP(int i, int color) {
        if (i == memo.length) {
            return 0;
        }
        if (memo[i][color] == null) {
            int best = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j != color) {
                    best = Math.min(best, costs[i][j] + minCostDP(i + 1, j));
                }
            }
            memo[i][color] = best;
        }
        return memo[i][color];
    }
}