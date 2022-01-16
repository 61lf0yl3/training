class LongestCommonSubsequence {
    // 1143. Longest Common Subsequence

    // Approach 1: Recursive (Time limit exceeded)
    // Time Complexity: O(N^2*M)
    // Space Complexity: O(N*M)
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int case1 = longestCommonSubsequence(text1.substring(1), text2);
        int firstOccurence = text2.indexOf(text1.charAt(0));
        int case2 = 0;
        if (firstOccurence != -1) {
            case2 = 1 + longestCommonSubsequence(text1.substring(1), text2.substring(firstOccurence + 1));
        }
        return Math.max(case1, case2);
    }

    // Approach 2: Recursive with Memoization
    // Time Complexity: O(N^2*M)
    // Space Complexity: O(N*M)
    int[][] memo;
    String text1;
    String text2;

    public int longestCommonSubsequence2(String text1, String text2) {
        // Make the memo big enough to hold the cases where the pointers
        // go over the edges of the strings.
        memo = new int[text1.length() + 1][text2.length() + 1];

        // We need to initialise the memo array to -1's so that we know
        // whether or not a value has been filled in. Keep the base cases
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        this.text1 = text1;
        this.text2 = text2;
        return longestCommonSubsequenceR(0, 0);
    }

    public int longestCommonSubsequenceR(int m1, int m2) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[m1][m2] != -1) {
            return memo[m1][m2];
        }

        // Case 1: we don't include text1[p1] in the solution.
        int case1 = longestCommonSubsequenceR(m1 + 1, m2);

        // Case 2: We include text1[p1] in the solution, as long as
        // a match for it in text2 at or after p2 exists.
        int firstOccurence = text2.indexOf(text1.charAt(m1), m2);
        int case2 = 0;
        if (firstOccurence != -1) {
            case2 = 1 + longestCommonSubsequenceR(m1 + 1, firstOccurence + 1);
        }

        // Add the best answer to the memo before returning it.
        memo[m1][m2] = Math.max(case1, case2);
        return memo[m1][m2];
    }

    // Approach 3: Recursive with Improved Memoization
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int longestCommonSubsequenceR3(int m1, int m2) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[m1][m2] != -1) {
            return memo[m1][m2];
        }

        int res = 0;
        // Case 1: If the first character of each string is the same
        if (text1.charAt(m1) == text2.charAt(m2)) {
            res = 1 + longestCommonSubsequenceR(m1 + 1, m2 + 1);
        } else {
            // Case 1: If the first character of each string is not the same
            res = Math.max(longestCommonSubsequenceR(m1 + 1, m2), longestCommonSubsequenceR(m1, m2 + 1));
        }
        // Add the best answer to the memo before returning it.
        memo[m1][m2] = res;
        return memo[m1][m2];
    }

    // Approach 4: DP bottom-up
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public int longestCommonSubsequence4(String text1, String text2) {
        // Make the memo big enough to hold the cases where the pointers
        // go over the edges of the strings.
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];

        // Iterate up each column, starting from the last one.
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                // If the corresponding characters for this cell are the same...
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                } else {
                    // Otherwise they must be different...
                    memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
                }
            }
        }
        // The original problem's answer is in dp_grid[0][0]. Return it.
        return memo[0][0];
    }

    // Approach 5: DP bottom-up with Space Optimization
    // Time Complexity: O(N*M)
    // Space Complexity: O(min(N*M))
    public int longestCommonSubsequence5(String text1, String text2) {

        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] prev = new int[text2.length() + 1];

        // Iterate up each column, starting from the last one.
        for (int col = text1.length() - 1; col >= 0; col--) {
            int[] curr = new int[text2.length() + 1];
            for (int row = text2.length() - 1; row >= 0; row--) {
                // If the corresponding characters for this cell are the same...
                if (text1.charAt(col) == text2.charAt(row)) {
                    curr[row] = 1 + prev[row + 1];
                } else {
                    // Otherwise they must be different...
                    curr[row] = Math.max(curr[row + 1], prev[row]);
                }
            }
            prev = curr;
        }
        // The original problem's answer is in dp_grid[0][0]. Return it.
        return prev[0];
    }

    // Approach 5: DP Top-Down
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    String text11;
    String text22;
    Integer[][] memo2;

    public int longestCommonSubsequence6(String text1, String text2) {
        this.text11 = text1;
        this.text22 = text2;
        int max = Math.max(text1.length(), text2.length());
        memo2 = new Integer[max][max];
        return longestCommonSubsequenceDP(0, 0);
    }

    private int longestCommonSubsequenceDP(int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo2[i][j] == null) {
            if (text1.charAt(i) == text2.charAt(j)) {
                memo[i][j] = 1 + longestCommonSubsequenceDP(i + 1, j + 1);
            } else {
                memo[i][j] = Math.max(longestCommonSubsequenceDP(i + 1, j),
                        longestCommonSubsequenceDP(i, j + 1));
            }
        }
        return memo[i][j];
    }
}