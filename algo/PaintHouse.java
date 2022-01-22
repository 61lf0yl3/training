class PaintHouse {

    // Approach 1: DP Bottom-Up ;
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minCost(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--) {
            costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
            costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
            costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
        }
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    }

    // Approach 2: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[][] costs;
    Integer[][] memo;

    public int minCost2(int[][] costs) {
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