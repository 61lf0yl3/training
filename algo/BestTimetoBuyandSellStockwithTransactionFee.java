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

    // Approach 1: DP Bottom-Up
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        int profit = 0;
        int hold = -prices[0];
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, hold + prices[i] - fee);
            hold = Math.max(hold, profit - prices[i]);
        }
        return profit;
    }

    // Approach 2: DP Top-Down
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    Integer[][] memo;
    int[] prices;
    int fee;

    public int maxProfit2(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        memo = new Integer[prices.length][2];
        return maxProfitDP(0, 0);
    }

    private int maxProfitDP(int i, int holding) {
        if (i == prices.length) {
            return 0;
        }
        if (memo[i][holding] == null) {
            int doNothing = maxProfitDP(i + 1, holding);
            int sellOrBuy;
            if (holding == 1) {
                sellOrBuy = prices[i] - fee + maxProfitDP(i + 1, 0);
            } else {
                sellOrBuy = -prices[i] + maxProfitDP(i + 1, 1);
            }
            memo[i][holding] = Math.max(sellOrBuy, doNothing);
        }
        return memo[i][holding];
    }

}