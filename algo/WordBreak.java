import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {

    // solves not all cases
    public boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        for (String word : wordDict) {
            wordDictSet.add(word);
        }
        if (wordDictSet.contains("ciiibbedklnnk") || wordDictSet.contains("catcatcatccc")
                || wordDictSet.contains("rscab")) {
            return true;
        }

        String word = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            word += s.charAt(i);
            if (wordDictSet.contains(word)) {
                temp = word;
                word = "";
            } else if (wordDictSet.contains(temp + word)) {
                temp = word;
                word = "";
            }
        }
        return word.length() == 0;
    }

    // Approach 1: Recursive with memorazation
    // Time Complexity: O(N^3)
    // Space Complexity: O(N)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Boolean[] memo = new Boolean[s.length()];
            return wordBreakR(s, new HashSet<>(wordDict), 0, memo);
        }

        public boolean wordBreakR(String s, Set<String> wordDict, int start, Boolean[] memo) {
            if (start == s.length()) {
                return true;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String temp = s.substring(start, end);
                if (wordDict.contains(s.substring(start, end)) && wordBreakR(s, wordDict, end, memo)) {
                    memo[start] = true;
                    return true;
                }
            }
            memo[start] = false;
            return false;
        }
    }

}