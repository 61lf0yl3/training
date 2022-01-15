import java.util.HashMap;
import java.util.Map;

class MinCostClimbingStairs {

    // Approach 1: DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            if (i == cost.length - 1) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2] + cost[i]);
            } else {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }
        }
        return dp[cost.length - 1];
    }

    // Approach 1: DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int[] cost;
    Map<Integer, Integer> m;

    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        this.cost = cost;
        m = new HashMap<>();
        return DP(cost.length);
    }

    private int DP(int i) {
        Map<Integer, Integer> temp = m;
        if (i <= 1) {
            return 0;
        }
        if (m.containsKey(i)) {
            return m.get(i);
        }
        int downOne = DP(i - 1) + cost[i - 1];
        int downTwo = DP(i - 2) + cost[i - 2];
        m.put(i, Math.min(downOne, downTwo));
        return m.get(i);
    }
}