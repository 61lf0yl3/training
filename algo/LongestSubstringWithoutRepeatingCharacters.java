import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    // 3. Longest Substring Without Repeating Characters

    // Approach 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(N)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), true);
            max = Math.max(map.size(), max);
            for (int j = i + 1; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    max = Math.max(map.size(), max);
                    map.clear();
                    break;
                } else {
                    map.put(s.charAt(j), true);
                    max = Math.max(map.size(), max);
                }
            }
        }
        return max;
    }

    // Approach 2: Sliding Window
    // Time Complexity: O(N)
    // Space Complexity: O(min(m))
    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];
        int low = 0;
        int high = 0;
        int res = 0;
        while (high < s.length()) {
            char h = s.charAt(high);
            chars[h]++;
            while (chars[h] > 1) {
                char l = s.charAt(low);
                chars[l]--;
                low++;
            }

            res = Math.max(res, high - low + 1);
            high++;
        }
        return res;
    }

    // Approach 3: One Pass (leetcode version)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int lengthOfLongestSubstring3(String s) {
        int res = 0;
        Map<Character, Integer> m = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int high = 0, low = 0; high < s.length(); high++) {
            char c = s.charAt(high);
            if (m.containsKey(c)) {
                low = Math.max(low, m.get(c));
            }
            res = Math.max(res, high - low + 1);
            m.put(c, high + 1);

        }
        return res;
    }
}