import java.util.HashMap;
import java.util.Map;

class DeleteandEarn {
    // 740. Delete and Earn

    // Approach 1: DP (Bottom-Up)
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int latsNotIncluded = 0, lastIncluded = 0, prev = -1;

        for (int i = min; i <= max; i++)
            if (count.containsKey(i)) {
                int temp = Math.max(latsNotIncluded, lastIncluded);
                if (i - 1 == prev) {
                    lastIncluded = i * count.get(i) + latsNotIncluded;
                    latsNotIncluded = temp;
                } else {
                    latsNotIncluded = temp;
                    lastIncluded = i * count.get(i) + temp;
                }
                prev = i;
            }

        return Math.max(lastIncluded, latsNotIncluded);
    }

    // Approach 1: DP Bottom-Up (leetcode version)
    // Time Complexity: O(N)
    // Space Complexity: O(N)
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

    // Approach 1: DP Top-Down (leetcode version)
    // Time Complexity: O(N)
    // Space Complexity: O(N)
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