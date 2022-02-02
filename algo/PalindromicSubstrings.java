class PalindromicSubstrings {
    // Approach 1: DP
    // Time Complexity: O(N^2)
    // Space Complexity: O(N^2)
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (r == c) {
                    palindrome[r][c] = true;
                    res++;
                } else if (s.charAt(r) == s.charAt(c)) {
                    if (c - r + 1 == 3 || c - r + 1 == 2) {
                        palindrome[r][c] = true;
                        res++;
                    }
                }
            }
        }

        // Approach 1: DP
        // Time Complexity: O(N^2)
        // Space Complexity: O(N^2)
        for (int r = n - 1; r >= 0; r--) {
            for (int c = r + 1; c < n; c++) {
                if (s.charAt(r) == s.charAt(c)) {
                    if (palindrome[r + 1][c - 1] && !palindrome[r][c]) {
                        palindrome[r][c] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings2(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res++;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}