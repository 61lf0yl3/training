import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    // 217. Contains Duplicate

    // Approach 1: Using HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}