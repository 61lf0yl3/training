public class SubarraySumEqualsK {
    // 560. Subarray Sum Equals K

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