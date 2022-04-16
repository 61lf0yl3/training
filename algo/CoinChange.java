import java.util.Arrays;

class CoinChange {
    // 322.Coin Change
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

    // Approach 2: Recursion with Memoization
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

    // Approach 2: DP
    // Time Complexity: O(S*N)
    // Space Complexity: O(N)
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int m = 1; m < dp.length; m++) {
            for (int c = 0; c < coins.length; c++) {
                int index = m - coins[c];
                if (index < 0) {
                    continue;
                } else {
                    dp[m] = Math.min(dp[m], dp[index] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    // Approach 2: DP Top-Down
    // Time Complexity: O(S*N)
    // Space Complexity: O(N)
    int[] coins;
    Integer[] memo1;

    public int coinChange4(int[] coins, int amount) {
        this.coins = coins;
        memo1 = new Integer[amount + 1];
        return dp(amount);
    }

    private int dp(int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo1[amount] == null) {
            int best = Integer.MAX_VALUE;
            for (int coin : coins) {
                int ret = dp(amount - coin);
                if (ret != -1) {
                    best = Math.min(best, ret + 1);
                }
            }
            if (best == Integer.MAX_VALUE) {
                best = -1;
            }
            memo1[amount] = best;
        }
        return memo1[amount];
    }
}