class InterleavingString {
    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N*M) Maximum day in days
    // Space Complexity: O(N*M)
    String s1;
    String s2;
    String s3;
    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s3.length() == 0) {
            return true;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        memo = new Boolean[s1.length()][s2.length()];
        return isInterleaveDP(0, 0);
    }

    private boolean isInterleaveDP(int i, int j) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(i + j));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(i + j));
        }
        if (memo[i][j] == null) {
            boolean ret = false;
            if (s1.charAt(i) == s3.charAt(i + j) && isInterleaveDP(i + 1, j)) {
                ret = true;
            }
            if (s2.charAt(j) == s3.charAt(i + j) && isInterleaveDP(i, j + 1)) {
                ret = true;
            }
            memo[i][j] = ret;
        }
        return memo[i][j];
    }

    // Approach 2: DP Bottom-up
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                } else {
                    dp[i][j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])
                            || (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    // Approach 2: DP Bottom-up with Optimized Space
    // Time Complexity: O(N*M)
    // Space Complexity: O(M)
    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1];
                } else if (j == 0) {
                    dp[j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j];
                } else {
                    dp[j] = (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1])
                            || (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j]);
                }
            }
        }

        return dp[s2.length()];
    }
}