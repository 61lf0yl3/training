public class ContinuousSubarraySum {
    // Approach 1: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public boolean checkSubarraySum(int[] nums, int k) {
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
