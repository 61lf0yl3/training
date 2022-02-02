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
}