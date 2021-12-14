class CoinChange {
    int res;

    // Approach 1: Recursion
    // Time Complexity: O(N*S)
    // Space Complexity: O(N)
    public int coinChange(int[] coins, int amount) {
        res = Integer.MAX_VALUE;
        coinChangeR(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        return res;
    }

    public void coinChangeR(int[] coins, int amount, int nb) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, nb);
            return;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            coinChangeR(coins, amount - coins[i], nb + 1);
        }
    }

}