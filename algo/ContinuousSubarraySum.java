import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    // Approach 1: Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (sum == 0 && i > 0) {
                return true;
            }
            if (m.containsKey(sum)) {
                if (i - m.get(sum) > 1) {
                    return true;
                }
            } else {
                m.put(sum, i);
            }

        }
        return false;
    }

    // Approach 2: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    return true;
                } else if (k == 0) {
                    return false;
                } else if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
