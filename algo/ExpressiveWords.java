class Solution {
    // Approach 1: Two Pointer
    // Time Complexity: O(N*M)
    // Space Complexity: O(1)
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean isStretchy(String word1, String word2) {
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) != word2.charAt(j)) {
                return false;
            }
            int x = i;
            int y = j;
            while (i < word1.length() && word1.charAt(i) == word1.charAt(x)) {
                i++;
            }
            while (j < word2.length() && word2.charAt(j) == word2.charAt(y)) {
                j++;
            }
            if ((i - x > j - y && i - x < 3) || j - y > i - x) {
                return false;
            }
        }

        return (i == word1.length()) && (j == word2.length());
    }
}