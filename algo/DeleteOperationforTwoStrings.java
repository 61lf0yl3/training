class DeleteOperationforTwoStrings {
    // 583. Delete Operation for Two Strings

    // Approach 5: DP bottom-up with Space Optimization
    // Time Complexity: O(N*M)
    // Space Complexity: O(min(N*M))
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        int[] prev = new int[word2.length() + 1];
        for (int col = word1.length() - 1; col >= 0; col--) {
            int[] curr = new int[word2.length() + 1];
            for (int row = word2.length() - 1; row >= 0; row--) {
                if (word1.charAt(col) == word2.charAt(row)) {
                    curr[row] = 1 + prev[row + 1];
                } else {
                    curr[row] = Math.max(curr[row + 1], prev[row]);
                }
            }
            prev = curr;
        }
        int maxLCS = prev[0];
        int res = word1.length() + word2.length() - 2 * maxLCS;
        return res;
    }

    // Using Longest Common Subsequence[Time Limit Exceeded]
    public int minDistance2(String s1, String s2) {
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
    }

    public int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }

    // Approach 3: Longest Common Subsequence with Memoization [Accepted]
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int minDistance3(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
    }

    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }
}