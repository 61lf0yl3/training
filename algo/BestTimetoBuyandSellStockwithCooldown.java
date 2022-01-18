class BestTimetoBuyandSellStockwithCooldown {

    // Approach 1: DP Top-Down with Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[] prices;
    int[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2];
        return maxProfitDP(0, 0);
    }

    private int maxProfitDP(int i, int holding) {
        if (i >= prices.length) {
            return 0;
        }
        if (memo[i][holding] == 0) {
            int notBuyOrSell = maxProfitDP(i + 1, holding);
            int BuyOrSell;
            if (holding == 1) {
                // Sell
                BuyOrSell = prices[i] + maxProfitDP(i + 2, 0);
            } else {
                // Buy
                BuyOrSell = -prices[i] + maxProfitDP(i + 1, 1);
            }
            memo[i][holding] = Math.max(notBuyOrSell, BuyOrSell);
        }
        return memo[i][holding];
    }

    // Approach 2: DP Bottom-Up (Tabulation)
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int notBuyOrSell = dp[i + 1][j];
                int BuyOrSell;
                if (j == 1) {
                    // Sell
                    BuyOrSell = prices[i] + dp[i + 2][0];
                } else {
                    // Buy
                    BuyOrSell = -prices[i] + dp[i + 1][1];
                }
                dp[i][j] = Math.max(notBuyOrSell, BuyOrSell);
            }
        }
        return dp[0][0];
    }
}