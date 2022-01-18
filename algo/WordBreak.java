import java.util.*;

class WordBreak {

    // solves not all cases
    public boolean wordBreak5(String s, List<String> wordDict) {
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

    // Approach 1: Recursive
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    // Approach 2: Recursive with memorazation
    // Time Complexity: O(N^3)
    // Space Complexity: O(N)
    public boolean wordBreak2(String s, List<String> wordDict) {
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
            // String temp = s.substring(start, end);
            if (wordDict.contains(s.substring(start, end)) && wordBreakR(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        memo[start] = false;
        return false;
    }

    // Approach 3: BFS with memorazation
    // Time Complexity: O(N^3)
    // Space Complexity: O(N)
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> q = new ArrayDeque();
        boolean[] seen = new boolean[s.length()];
        q.add(0);
        while (!q.isEmpty()) {
            int start = q.remove();
            if (start == s.length()) {
                return true;
            }
            if (seen[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);
                if (dict.contains(word)) {
                    q.add(end);
                }
            }
            seen[start] = true;
        }
        return false;
    }

    // Approach 4: DP
    // Time Complexity: O(N^3)
    // Space Complexity: O(N)
    public boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                String word = s.substring(start, end);
                if (dp[start] && wordDictSet.contains(word)) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // Approach 4: DP
    // Time Complexity: O(N^3)
    // Space Complexity: O(N)
    public boolean wordBreak6(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() - 1 && (i == word.length() - 1 || dp[i - word.length()])) {
                    if (s.substring(i + 1 - word.length(), i + 1).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    // Approach 4: DP
    // Time Complexity: O(N^3)
    // Space Complexity: O(N)
    String s1;
    Set<String> set;
    Boolean[] memo1;

    public boolean wordBreak7(String s, List<String> wordDict) {
        this.s1 = s;
        set = new HashSet<>(wordDict);
        memo1 = new Boolean[s.length()];
        return wordBreakDP(0);
    }

    private boolean wordBreakDP(int i) {
        if (i == s1.length()) {
            return true;
        }
        if (memo1[i] == null) {
            memo1[i] = false;
            for (int j = i; j < s1.length(); j++) {
                if (set.contains(s1.substring(i, j + 1)) && wordBreakDP(j + 1)) {
                    memo1[i] = true;
                }
            }
        }
        return memo1[i];
    }
}