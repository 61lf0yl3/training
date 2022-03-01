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
