public class BestTimetoBuyandSellStock2 {
    // Approach 1: Top-Down with Memorazation
    // Time Complexity: O(1)
    // Space Complexity: O(N)
    int[] prices;
    Integer[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new Integer[prices.length][2];
        return dp(0, 0);
    }

    private int dp(int i, int hold) {
        if (i >= prices.length) {
            return 0;
        }
        if (memo[i][hold] == null) {
            int doNothing = dp(i + 1, hold);
            int buyOrSell = 0;
            if (hold == 0) {
                // we buy
                buyOrSell = -prices[i] + dp(i + 1, 1);
            } else {
                // we sell
                buyOrSell = prices[i] + dp(i + 1, 0);
            }
            memo[i][hold] = Math.max(doNothing, buyOrSell);
        }
        return memo[i][hold];
    }
}
