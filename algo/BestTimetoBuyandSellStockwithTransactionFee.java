class BestTimetoBuyandSellStockwithTransactionFee {
    // 714. Best Time to Buy and Sell Stock with Transaction Fee

    // Approach 1: DP Bottom-Up
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int doNothing = dp[i + 1][j];
                int sellOrBuy;
                if (j == 1) {
                    sellOrBuy = prices[i] - fee + dp[i + 1][0];
                } else {
                    sellOrBuy = -prices[i] + dp[i + 1][1];
                }
                dp[i][j] = Math.max(sellOrBuy, doNothing);
            }
        }
        return dp[0][0];
    }

}