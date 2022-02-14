import java.util.HashMap;
import java.util.Map;

public class MakingFileNamesUnique {
    // Approach 1: Using Hash
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> m = new HashMap<>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String key = names[i];
            int value = 0;
            if (m.containsKey(key)) {
                value = m.get(key);
            }
            while (m.containsKey(key)) {
                key = names[i] + "(" + ++value + ")";
            }

            m.put(key, 0);
            m.put(names[i], value);
            names[i] = key;
        }
        return names;
    }
}
