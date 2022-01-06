import java.util.HashSet;
import java.util.Set;

class Solution {
    // 217. Contains Duplicate

    // Approach 1: Using HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}