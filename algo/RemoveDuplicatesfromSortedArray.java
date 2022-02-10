public class RemoveDuplicatesfromSortedArray {
    // Approach 1: Two Pointers
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
