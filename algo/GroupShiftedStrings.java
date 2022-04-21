import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // Approach 2: Using HashMap
    // Time Complexity: O(N*K)
    // Space Complexity: O(N*K)
    char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }

    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();

        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        String hashKey = String.valueOf(chars);
        return hashKey;
    }

    public List<List<String>> groupStrings2(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();

        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["abc"] = ["abc", "bcd"]
        for (String str : strings) {
            String hashKey = getHash(str);
            if (mapHashToList.get(hashKey) == null) {
                mapHashToList.put(hashKey, new ArrayList<>());
            }
            mapHashToList.get(hashKey).add(str);
        }

        // Iterate over the map, and add the values to groups
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : mapHashToList.values()) {
            groups.add(group);
        }

        return groups;
    }

    public List<List<String>> groupStrings3(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();

        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["cd"] = ["acf", "gil", "xzc"]
        for (String str : strings) {
            String hashKey = getHash(str);
            if (mapHashToList.get(hashKey) == null) {
                mapHashToList.put(hashKey, new ArrayList<>());
            }
            mapHashToList.get(hashKey).add(str);
        }

        // Iterate over the map, and add the values to groups
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : mapHashToList.values()) {
            groups.add(group);
        }

        // Return a list of all of the grouped strings
        return groups;
    }
}