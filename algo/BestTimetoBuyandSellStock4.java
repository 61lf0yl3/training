class BestTimetoBuyandSellStock4 {

    // Approach 3: DP Top-Down with Memoization
    // Time Complexity: O(N*K)
    // Space Complexity: O(N*K)
    int[] prices;
    int[][][] memo;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][k + 1][2];
        return maxProfitDP(0, k, 0);
    }

    public int maxProfitDP(int i, int k, int holding) {
        if (i == prices.length || k == 0) {
            return 0;
        }
        if (memo[i][k][holding] == 0) {
            int doNothing = maxProfitDP(i + 1, k, holding);
            int sellOrBuy;
            if (holding == 1) {
                sellOrBuy = prices[i] + maxProfitDP(i + 1, k - 1, 0);
            } else {
                sellOrBuy = -prices[i] + maxProfitDP(i + 1, k, 1);
            }
            memo[i][k][holding] = Math.max(doNothing, sellOrBuy);
        }
        return memo[i][k][holding];
    }

    // Approach 3: DP Bottom-Up (Tabulation)
    // Time Complexity: O(N*K)
    // Space Complexity: O(N*K)
    public int maxProfit2(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][k + 1][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = k; j > 0; j--) {
                for (int h = 0; h <= 1; h++) {
                    int doNothing = dp[i + 1][j][h];
                    int sellOrBuy;
                    if (h == 1) {
                        sellOrBuy = prices[i] + dp[i + 1][j - 1][0];
                    } else {
                        sellOrBuy = -prices[i] + dp[i + 1][j][1];
                    }
                    dp[i][j][h] = Math.max(doNothing, sellOrBuy);
                }
            }
        }

        return dp[0][k][0];
    }
}