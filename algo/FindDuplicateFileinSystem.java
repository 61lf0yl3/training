import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    // Approach 1: Using HashMap
    // Time Complexity: O(N*X) n strings of average length x is parsed
    // Space Complexity: O(N*X) map and res size grows upto n*x
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> m = new HashMap<>();
        for (String path : paths) {
            String[] chunks = path.split(" ");
            for (int i = 1; i < chunks.length; i++) {
                String[] parts = chunks[i].split("\\(");
                if (!m.containsKey(parts[1])) {
                    m.put(parts[1], new ArrayList<>());
                }
                m.get(parts[1]).add(chunks[0] + "/" + parts[0]);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> value : m.values()) {
            if (value.size() > 1) {
                res.add(value);
            }
        }
        return res;
    }
}
