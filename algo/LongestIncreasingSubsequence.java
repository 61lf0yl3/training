import java.util.ArrayList;
import java.util.Arrays;

class LongestIncreasingSubsequence {
    // 300. Longest Increasing Subsequence

    // Approach 1: DP
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    // Approach 2: Intelligently Build a Subsequence
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int lengthOfLIS2(int[] nums) {
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > subset.get(subset.size() - 1)) {
                subset.add(nums[i]);
            } else {
                int j = 0;
                while (nums[i] > subset.get(j)) {
                    j++;
                }
                subset.set(j, nums[i]);
            }
        }
        return subset.size();
    }
}