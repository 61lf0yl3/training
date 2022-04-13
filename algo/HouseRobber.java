import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class HouseRobber {
    // 198. House Robber

    // Approach 1: DP Optimized
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int rob(int[] nums) {
        int res = 0;
        int n = nums.length;
        int oldest = 0;
        int old = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = nums[i];
            int prevRes = res;
            res = Math.max(res, Math.max(curr + old, curr + oldest));
            oldest = old;
            old = prevRes;
        }
        return res;
    }

    // Approach 1: DP Optimized
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int rob5(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }return dp[nums.length-1];}

    // Approach 2: Recursion
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    private int[] nums;
    private Integer[] memo1;

    public int rob4(int[] nums) {
        this.nums = nums;
        memo1 = new Integer[nums.length];
        return dp(nums.length - 1);
    }

    private int dp(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo1[i] == null) {
            memo1[i] = Math.max(dp(i - 1), dp(i - 2) + nums[i]);
        }
        return memo[i];
    }

    // Approach 2: Recursion
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int res;

    public int rob2(int[] nums) {
        res = 0;
        robR(nums, 0, 0);
        return res;
    }

    public void robR(int[] nums, int index, int sum) {
        if (index >= nums.length) {
            res = Math.max(res, sum);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            robR(nums, i + 2, sum + nums[i]);
            robR(nums, i + 3, sum + nums[i]);
        }
    }

    // Approach 3: Recursion
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    private int[] memo;

    public int rob3(int[] nums) {

        this.memo = new int[100];

        // Fill with sentinel value representing not-calculated recursions.
        Arrays.fill(this.memo, -1);

        return this.robFrom(0, nums);
    }

    private int robFrom(int i, int[] nums) {

        // No more houses left to examine.
        if (i >= nums.length) {
            return 0;
        }

        // Return cached value.
        if (this.memo[i] > -1) {
            return this.memo[i];
        }

        // Recursive relation evaluation to get the optimal answer.
        int ans = Math.max(this.robFrom(i + 1, nums), this.robFrom(i + 2, nums) + nums[i]);

        // Cache for future use.
        this.memo[i] = ans;
        return ans;
    }

}