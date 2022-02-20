import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    // Approach 1: Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int balance = 0;
        int res = 0;
        m.put(balance, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                balance++;
            } else {
                balance--;
            }
            if (!m.containsKey(balance)) {
                m.put(balance, i);
            } else {
                res = Math.max(res, i - m.get(balance));
            }
        }
        return res;
    }
}
