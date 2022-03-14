import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumEarningsFromTaxi {
    // Approach 1: Top-Down Dynamic Programming+Binary Search
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    int[][] rides;
    long[] memo;
    int n;

    public long maxTaxiEarnings(int n, int[][] rides) {
        this.n = n;
        this.rides = rides;
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        memo = new long[rides.length];
        Arrays.fill(memo, -1);
        return DP(0);
    }

    private long DP(int i) {
        // int[][] rides1 = rides;
        // long[] memo1 = memo;
        if (i >= rides.length) {
            return 0;
        }
        if (memo[i] == -1) {
            int nextIndex = findNextJob(rides[i][1]);
            // while (nextIndex < rides.length && rides[nextIndex][0] < rides[i][1]) {
            // nextIndex++;
            // }
            long best = Math.max(DP(i + 1), rides[i][1] - rides[i][0] + rides[i][2] + DP(nextIndex));
            memo[i] = best;
        }
        return memo[i];
    }

    private int findNextJob(long lastEndingTime) {
        int start = 0;
        int end = rides.length - 1;
        int nextIndex = rides.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (rides[mid][0] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

    // Approach 2: Bottom-Up Dynamic Programming+Binary Search
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();
        Arrays.fill(memo, -1);

        int length = profit.length;

        for (int i = 0; i < length; i++) {
            ArrayList<Integer> currJob = new ArrayList<>();
            currJob.add(startTime[i]);
            currJob.add(endTime[i]);
            currJob.add(profit[i]);
            jobs.add(currJob);
        }
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));

        for (int i = 0; i < length; i++) {
            startTime[i] = jobs.get(i).get(0);
        }

        int[] dp = new int[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            int nextIndex = findNextJob(jobs.get(i).get(1));
            int nextIndexProfit = 0;
            if (nextIndex <= length) {
                nextIndexProfit = dp[nextIndex];
            }
            int maxProfit = Math.max(jobs.get(i).get(2) + nextIndexProfit, dp[i + 1]);
            dp[i] = maxProfit;
        }

        return dp[0];
    }

}
