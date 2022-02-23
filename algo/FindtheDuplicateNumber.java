public class FindtheDuplicateNumber {
    // Approach 1: Floyd's Tortoise and Hare (Cycle Detection)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findDuplicate(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
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
