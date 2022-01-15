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
}