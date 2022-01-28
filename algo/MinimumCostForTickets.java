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

    // Approach 1: DP Top-Down (Recursion with memorazation);
    // Time Complexity: O(N) where N is the number of unique days in your travel
    // plan.
    // Space Complexity: O(N)
    public int mincostTickets2(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new int[days.length];
        return mincostTicketsDP2(0);
    }

    private int mincostTicketsDP2(int i) {
        int[] memo1 = memo;
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] == 0) {

            // 1-day pass
            int ret = costs[0] + mincostTicketsDP(i + 1);
            int j = i;

            // 7-day pass
            while (j < days.length && days[j] < days[i] + 7) {
                j++;
            }
            ret = Math.min(ret, costs[1] + mincostTicketsDP(j));

            // 30-day pass
            while (j < days.length && days[j] < days[i] + 30) {
                j++;
            }
            ret = Math.min(ret, costs[2] + mincostTicketsDP(j));
            memo[i] = ret;
        }
        return memo[i];
    }
}