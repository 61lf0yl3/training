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
}