public class SubarraySumEqualsK {
    // 560. Subarray Sum Equals K

    // Approach #2: Using Cumulative Sum
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        for (int start = 0; start < sum.length - 1; start++) {
            for (int end = start + 1; end < sum.length; end++) {
                if (sum[end] - sum[start] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    // Approach #3: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int subarraySum3(int[] nums, int k) {
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