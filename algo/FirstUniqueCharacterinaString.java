import java.util.HashMap;
import java.util.Map;

class FirstUniqueCharacterinaString {
    // 387. First Unique Character in a String

    // Approach 1: Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    // Approach 2: Using Arrays
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int firstUniqChar2(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}