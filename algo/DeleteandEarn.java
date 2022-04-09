import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class DeleteandEarn {
    // 740. Delete and Earn

    // Approach 1: DP (Bottom-Up)
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public int deleteAndEarn(int[] input) {
        HashMap<Integer, Integer> nums = new HashMap<>();

        for (int num : input) {
            nums.put(num, nums.getOrDefault(num, 0) + num);
        }

        ArrayList<Integer> elements = new ArrayList<>(nums.keySet());
        Collections.sort(elements);

        // Base cases
        int twoBack = 0;
        int oneBack = nums.get(elements.get(0));

        for (int i = 1; i < elements.size(); i++) {
            int num = elements.get(i);
            int temp = oneBack;
            if (num == elements.get(i - 1) + 1) {
                oneBack = Math.max(temp, twoBack + nums.get(num));
            } else {
                oneBack += nums.get(num);
            }
            twoBack = temp;
        }

        return oneBack;
    }

    // Approach 2: DP Bottom-Up (leetcode version)
    // Time Complexity: O(N+k)
    // Space Complexity: O(N+k)
    public int deleteAndEarn2(int[] nums) {
        int[] count = new int[10001];
        for (int x : nums)
            count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k)
            if (count[k] > 0) {
                int m = Math.max(avoid, using);
                if (k - 1 != prev) {
                    using = k * count[k] + m;
                    avoid = m;
                } else {
                    using = k * count[k] + avoid;
                    avoid = m;
                }
                prev = k;
            }
        return Math.max(avoid, using);
    }

    // Approach 3: DP Bottom-Up
    // Time Complexity: O(N+k)
    // Space Complexity: O(N+k)
    public int deleteAndEarn4(int[] input) {
        HashMap<Integer, Integer> nums = new HashMap<>();

        int max = 0;
        for (int num : input) {
            nums.put(num, nums.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];
        dp[1] = nums.getOrDefault(1, 0);

        for (int num = 2; num < dp.length; num++) {
            int points = nums.getOrDefault(num, 0);
            dp[num] = Math.max(dp[num - 1], dp[num - 2] + points);
        }

        return dp[max];
    }

    // Approach 3: DP Top-Down (leetcode version)
    // Time Complexity: O(N+k)
    // Space Complexity: O(N+k)
    HashMap<Integer, Integer> nums;
    HashMap<Integer, Integer> memo;

    public int deleteAndEarn3(int[] nums) {
        this.nums = new HashMap<>();
        memo = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            this.nums.put(num, this.nums.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }
        return dp(max);
    }

    private int dp(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return nums.getOrDefault(1, 0);
        }
        if (!memo.containsKey(num)) {
            int points = nums.getOrDefault(num, 0);
            memo.put(num, Math.max(dp(num - 1), dp(num - 2) + points));
        }
        return memo.get(num);
    }
}