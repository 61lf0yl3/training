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

    // Approach 2: DP Bottom-Up Optimized Time;
    // Time Complexity: O(N*K)
    // Space Complexity: O(1)
    public int minCostII2(int[][] costs) {
        for (int i = costs.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {
                if (costs[i + 1][j] < min) {
                    secondMin = min;
                    min = costs[i + 1][j];
                } else if (costs[i + 1][j] < secondMin) {
                    secondMin = costs[i + 1][j];
                }
            }
            for (int j = 0; j < costs[0].length; j++) {
                if (min == costs[i + 1][j]) {
                    costs[i][j] += secondMin;
                } else {
                    costs[i][j] += min;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++) {
            res = Math.min(res, costs[0][j]);
        }
        return res;
    }

    // Approach 1: DP Bottom-Up ;
    // Time Complexity: O(N*K^2)
    // Space Complexity: O(1)
    public int minCostII3(int[][] costs) {
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
