public class FindtheDuplicateNumber {
    // Approach 1: Negative Marking
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findDuplicate(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            nums[curr] *= -1;
            if (nums[curr] > 0) {
                res = curr;
            }
        }
        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);
        return res;
    }
}
