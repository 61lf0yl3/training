import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestStringChain {
    // 1048. Longest String Chain

    // Approach 1: Recursion + Memoization
    // Time Complexity: O(N)
    // Space Complexity: O(D) , where D is a tree diameter.
    int res;
    Set<String> s;
    Map<String, Integer> m;

    public int longestStrChain(String[] words) {
        res = 0;
        s = new HashSet<>();
        m = new HashMap<>();

        for (String word : words) {
            s.add(word);
        }
        for (String word : words) {
            longestStrChainR(word);
        }
        return res;
    }

    public int longestStrChainR(String word) {
        if (m.containsKey(word)) {
            return m.get(word);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String predecessor = sb.toString();
            if (s.contains(predecessor)) {
                int currLength = 1 + longestStrChainR(predecessor);
                maxLength = Math.max(maxLength, currLength);
            }
            sb.insert(i, word.charAt(i));

        }
        m.put(word, maxLength);
        res = Math.max(res, maxLength);
        return maxLength;
    }
}