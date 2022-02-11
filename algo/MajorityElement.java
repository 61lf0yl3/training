import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    // Approach 1: Iterative Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;
        int maxFreq = 0;
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            if (m.get(num) > maxFreq) {
                maxFreq = m.get(num);
                max = num;
            }
        }
        return max;
    }
}