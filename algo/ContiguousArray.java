import java.util.Arrays;
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

    // Approach 1: Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findMaxLength2(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }
}
