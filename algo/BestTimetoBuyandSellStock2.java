public class BestTimetoBuyandSellStock2 {

    // Approach 1: Iterative DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                int doNothing = dp[i + 1][j];
                int buyOrSell = 0;
                if (j == 0) {
                    // we buy
                    buyOrSell = -prices[i] + dp[i + 1][1];
                } else {
                    // we sell
                    buyOrSell = prices[i] + dp[i + 1][0];
                }
                dp[i][j] = Math.max(doNothing, buyOrSell);
            }
        }

        return dp[0][0];
    }

    // Approach 1: DP Top-Down with Memorazation
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[] prices;
    Integer[][] memo;

    public int maxProfit2(int[] prices) {
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
