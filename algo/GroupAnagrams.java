import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    // 49. Group Anagrams

    // Approach 1: = HashMap
    // Time Complexity: O(M*NlogN)
    // Space Complexity: O(k)
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
}