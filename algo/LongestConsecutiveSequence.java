import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // Approach 1: HashSet and Intelligent Sequence Building
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }

        int res = 0;
        for (int num : s) {
            if (!s.contains(num - 1)) {
                int curr = num + 1;
                int substring = 1;
                while (s.contains(curr)) {
                    curr++;
                    substring++;
                }
                res = Math.max(res, substring);
            }
        }
        return res;
    }

    // Approach 1: Sorting
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int res = 1;
        int consecutive = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                if (nums[i] == nums[i - 1] + 1) {
                    consecutive++;
                } else {
                    res = Math.max(res, consecutive);
                    consecutive = 1;
                }
            }
        }
        res = Math.max(res, consecutive);
        return res;
    }

    // Approach 1: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int longestConsecutive3(int[] nums) {
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
