class CoinChange {
    int res;

    // Approach 1: Recursion
    // Time Complexity: O(S^N)
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

    // Approach 2: DP
    // Time Complexity: O(S*N)
    // Space Complexity: O(N)
    Integer[] memo;

    public int coinChange2(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        return coinChangeR(coins, amount);
    }

    public int coinChangeR(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        for (int i = 0; i < coins.length; i++) {
            int nb = coinChangeR(coins, amount - coins[i]);
            if (nb == -1) {
                continue;
            }
            if (memo[amount] == null) {
                memo[amount] = nb + 1;
            } else {
                memo[amount] = Math.min(nb + 1, memo[amount]);
            }
        }
        if (memo[amount] == null) {
            memo[amount] = -1;
        }
        return memo[amount];
    }
}