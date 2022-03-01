import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    // Approach 2: Monotonus Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && nums2[i] > s.peek()) {
                m.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }

        while (!s.isEmpty()) {
            m.put(s.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = m.get(nums1[i]);
        }
        return res;
    }
}
