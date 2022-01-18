class BestTimetoBuyandSellStockwithCooldown {

    // Approach 3: DP Top-Down with Memoization
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
}