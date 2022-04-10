import java.util.Arrays;
import java.util.HashMap;

public class ContiguousArray {
    // Approach 1: Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (m.containsKey(count)) {
                res = Math.max(res, i - m.get(count));
            } else {
                m.put(count, i);
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

        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (arr[count + nums.length] == -2) {
                arr[count + nums.length] = i;
            } else {
                res = Math.max(res, i - arr[count + nums.length]);
            }
        }
        return res;
    }
}
