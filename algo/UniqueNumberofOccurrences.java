import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberofOccurrences {
    // Approach 1: Iterative using HashMap and HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : arr) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        Set<Integer> s = new HashSet<>();
        for (int num : m.values()) {
            if (!s.contains(num)) {
                s.add(num);
            } else {
                return false;
            }
        }
        return true;
    }
}
