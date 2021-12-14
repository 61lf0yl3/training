class IntegerBreak {

    // Approach 2: Recursion with Memoization
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        memo[1] = 1;
        return integerBreakR(n, memo);
    }

    public int integerBreakR(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int temp = 0;
        for (int i = 1; i <= n / 2; i++) {
            // int temp1 = n-i;
            // int temp2 = integerBreakR(n-i, memo);
            // int temp3 = Math.max(temp1, temp2);
            // temp = temp3*i;
            temp = i * Math.max(n - i, integerBreakR(n - i, memo));
            memo[n] = Math.max(memo[n], temp);
        }
        return memo[n];
    }

    // Approach 2: DP
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int integerBreak2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int num = 2; num <= n; num++) {
            for (int i = 1; i <= num / 2; i++) {
                int temp = i * Math.max(num - i, memo[num - i]);
                memo[num] = Math.max(memo[num], temp);
            }
        }
        return memo[n];
    }

}