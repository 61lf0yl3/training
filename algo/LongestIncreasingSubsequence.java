import java.util.ArrayList;
import java.util.Arrays;

class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        System.out.println(binarySearch(nums, 1));
    }
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

    // Approach 2: Intelligently Build a Subsequence Improved With Binary Search
    // Time Complexity: O(N^2)
    // Space Complexity: O(N)
    public int lengthOfLIS3(int[] nums) {
        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > subset.get(subset.size() - 1)) {
                subset.add(nums[i]);
            } else {
                int j = binarySearch(subset, nums[i]);
                subset.set(j, nums[i]);
            }
        }
        return subset.size();
    }

    public int binarySearch(ArrayList<Integer> subset, int num) {
        int low = 0;
        int high = subset.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num > subset.get(mid)) {
                low = mid + 1;
            } else if (num < subset.get(mid)) {
                high = mid;
            } else {
                return mid;
            }
        }
        return low;
    }
}