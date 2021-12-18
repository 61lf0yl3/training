class LongestCommonSubsequence {
    // 1143. Longest Common Subsequence

    // Approach 1: Recursive (Time limit exceeded)
    // Time Complexity: O(N*M)
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
    // Time Complexity: O(N*M)
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
}