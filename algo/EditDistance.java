class EditDistance {
    public int minDistance(String word1, String word2) {
        // if one of the strings is empty
        if (word1.length() * word2.length() == 0) {
            return word1.length() + word2.length();
        }

        // array to store the convertion history
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // init boundaries
        for (int row = 1; row <= word1.length(); row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col <= word2.length(); col++) {
            dp[0][col] = col;
        }
        // DP compute
        for (int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    dp[row][col] = 1 + Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1] - 1);
                } else {
                    dp[row][col] = 1 + Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}