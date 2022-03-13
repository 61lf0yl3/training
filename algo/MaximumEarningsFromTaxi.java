import java.util.Arrays;

// Approach 1: Top-Down Dynamic Programming+Binary Search
// Time Complexity: O(NlogN)
// Space Complexity: O(N)
public class MaximumEarningsFromTaxi {
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

}
