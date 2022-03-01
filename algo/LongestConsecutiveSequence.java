public class LongestConsecutiveSequence {
    // Approach 1: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int longestConsecutive(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int curr = num;
            int substring = 1;
            while (contains(nums, curr + 1)) {
                curr++;
                substring++;
            }
            res = Math.max(res, substring);
        }
        return res;
    }

    public boolean contains(int nums[], int curr) {
        for (int num : nums) {
            if (num == curr) {
                return true;
            }
        }
        return false;
    }
}
