class PaintHouse2 {
    // Approach 2: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[][] costs;
    Integer[][] memo;

    public int minCostII(int[][] costs) {
        this.costs = costs;
        memo = new Integer[costs.length][costs[0].length + 1];
        return minCostIIDP(0, costs[0].length);
    }

    private int minCostIIDP(int i, int color) {
        Integer[][] memo1 = memo;
        if (i == costs.length) {
            return 0;
        }
        if (memo[i][color] == null) {
            int best = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                if (j != color) {
                    best = Math.min(best, costs[i][j] + minCostIIDP(i + 1, j));
                }
            }
            memo[i][color] = best;
        }
        return memo[i][color];
    }

    // Approach 2: DP Bottom-Up ;
    // Time Complexity: O(N*K^2)
    // Space Complexity: O(1)
    public int minCostII2(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--) {
            for (int j = 0; j < costs[0].length; j++) {
                int best = Integer.MAX_VALUE;
                for (int m = 0; m < costs[0].length; m++) {
                    if (j != m) {
                        best = Math.min(best, costs[i + 1][m]);
                    }
                }
                costs[i][j] += best;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++) {
            res = Math.min(res, costs[0][j]);
        }
        return res;
    }
}
