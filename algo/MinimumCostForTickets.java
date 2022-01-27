import java.util.HashSet;
import java.util.Set;

class MinimumCostForTickets {
    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(W) Maximum day in days
    // Space Complexity: O(W)
    int[] days;
    int[] costs;
    int[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        dayset = new HashSet<>();
        for (int day : days) {
            dayset.add(day);
        }
        memo = new int[days[days.length - 1] + 1];
        return mincostTicketsDP(1);
    }

    private int mincostTicketsDP(int i) {
        if (i > days[days.length - 1]) {
            return 0;
        }
        if (memo[i] == 0) {
            int ret;
            if (dayset.contains(i)) {
                ret = Math.min(mincostTicketsDP(i + 1) + costs[0],
                        mincostTicketsDP(i + 7) + costs[1]);
                ret = Math.min(ret, mincostTicketsDP(i + 30) + costs[2]);
            } else {
                ret = mincostTicketsDP(i + 1);
                ;
            }
            memo[i] = ret;
        }
        return memo[i];
    }
}