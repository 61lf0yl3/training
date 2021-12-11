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

    // Approach 1: Sliding Window
    // Time Complexity: O(N)
    // Space Complexity: O(min(m))
    public int lengthOfLongestSubstring2(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    // Approach 1: One Pass (leetcode version)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}