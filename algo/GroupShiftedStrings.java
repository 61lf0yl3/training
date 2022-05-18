import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupShiftedStrings {
    // 249. Group Shifted Strings

    // Approach 1: Using HashMap
    // Time Complexity: O(N*K)
    // Space Complexity: O(N*K)
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, ArrayList<String>> m = new HashMap<>();

        for (String word : strings) {
            int diff = word.charAt(0) - 'a';
            StringBuilder temp = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c - diff < 'a') {
                    temp.append((char) (c - diff + 26));
                } else {
                    temp.append((char) (c - diff));
                }
            }
            if (!m.containsKey(temp.toString())) {
                m.put(temp.toString(), new ArrayList<>());
            }
            m.get(temp.toString()).add(word);
        }

        List<List<String>> res = new ArrayList<>();
        for (ArrayList<String> value : m.values()) {
            res.add(value);
        }

        return res;
    }
}