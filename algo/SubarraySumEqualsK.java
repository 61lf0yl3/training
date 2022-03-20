import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // 560. Subarray Sum Equals K

    // Approach 1: Using Hashmap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (m.containsKey(sum - k)) {
                res += m.get(sum - k);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    // Approach 2: Without Space
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // Approach 3: Using Cumulative Sum
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int subarraySum3(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (m.containsKey(sum - k)) {
                res += m.get(sum - k);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    // Approach #4: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int subarraySum4(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}