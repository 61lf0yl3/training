public class FindtheDuplicateNumber {
    // Approach 1: Floyd's Tortoise and Hare (Cycle Detection)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findDuplicate(int[] nums) {

        // Find the intersection point of the two runners.
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the "entrance" to the cycle.
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    // Approach 2: Negative Marking
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findDuplicate2(int[] nums) {
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
