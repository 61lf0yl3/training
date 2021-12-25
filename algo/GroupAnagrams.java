import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    // 49. Group Anagrams

    // Approach 1: HashMap
    // Time Complexity: O(M*NlogN)
    // Space Complexity: O(M*N)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> group = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String anagram = String.valueOf(chars);

            List<String> anagrams = new ArrayList<>();
            if (group.containsKey(anagram)) {
                anagrams = group.get(anagram);
            } else {
                group.put(anagram, anagrams);
            }
            anagrams.add(word);
        }

        for (List<String> anagrams : group.values()) {
            res.add(anagrams);
        }
        return res;
    }

    // Approach 2: Categorize by Count
    // Time Complexity: O(M*NlogN)
    // Space Complexity: O(M*N)
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                while (chars[i] > 0) {
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
            String key = sb.toString();
            List<String> anagrams = new ArrayList<>();
            if (m.containsKey(key)) {
                anagrams = m.get(key);
            } else {
                m.put(key, anagrams);
            }
            anagrams.add(s);
        }
        return new ArrayList(m.values());
    }
}