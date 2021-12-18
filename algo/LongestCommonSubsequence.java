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

}