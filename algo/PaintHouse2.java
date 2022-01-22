class PaintHouse2 {
    // Approach 1: DP Bottom-Up ;
    // Time Complexity: O(N*K^2)
    // Space Complexity: O(1)
    public int minCostII(int[][] costs) {
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
