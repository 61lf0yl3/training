class IntegerBreak {

    // Approach 2: Recursion with Memoization
    // Time Complexity: O(S*N)
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
            ;
        }
        return memo[n];
    }

}