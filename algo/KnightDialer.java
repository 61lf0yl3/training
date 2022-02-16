public class KnightDialer {
    // Approach 1: Top-Down with Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int MOD = 1000000007;
    int[][] map = { { 0, 4, 6 }, { 1, 6, 8 }, { 2, 7, 9 }, { 3, 4, 8 }, { 4, 0, 3, 9 }, { 5 }, { 6, 0, 1, 7 },
            { 7, 2, 6 }, { 8, 1, 3 }, { 9, 2, 4 } };

    int[][] memo;

    public int knightDialer(int n) {
        memo = new int[10][n + 1];
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            res += dp(i, n);
            res %= MOD;
        }

        return res;
    }

    private int dp(int i, int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[i][n] == 0) {
            int sum = 0;
            for (int j = 1; j < map[i].length; j++) {
                sum += dp(map[i][j], n - 1);
                sum %= MOD;
            }
            memo[i][n] = sum;
        }
        return memo[i][n];
    }
}
