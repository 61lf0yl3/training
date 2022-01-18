class BestTimetoBuyandSellStock4 {

    // Approach 3: DP Top-Down with Memoization
    // Time Complexity: O(N^3)
    // Space Complexity: O(N^3)
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
}