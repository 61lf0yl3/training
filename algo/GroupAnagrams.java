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
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> group = new HashMap<>();
        for (String word : strs) {
            List<String> anagrams = new ArrayList<>();
            String anagram = sortString(word);
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

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}