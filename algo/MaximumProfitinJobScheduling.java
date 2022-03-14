import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Approach 1: Top-Down Dynamic Programming+Binary Search
// Time Complexity: O(NlogN)
// Space Complexity: O(N)
public class MaximumProfitinJobScheduling {

    int[] memo = new int[50001];
    List<List<Integer>> jobs;
    int[] startTime;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new ArrayList<>();
        Arrays.fill(memo, -1);

        int length = profit.length;
        this.startTime = startTime;

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
        return findMaxProfit(0);
    }

    private int findMaxProfit(int position) {
        if (position >= startTime.length) {
            return 0;
        }
        if (memo[position] == -1) {
            int nextIndex = findNextJob(jobs.get(position).get(1));

            int maxProfit = Math.max(jobs.get(position).get(2) + findMaxProfit(nextIndex),
                    findMaxProfit(position + 1));
            memo[position] = maxProfit;

        }
        return memo[position];
    }

    private int findNextJob(int lastEndingTime) {
        int start = 0;
        int end = startTime.length - 1;
        int nextIndex = startTime.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (startTime[mid] >= lastEndingTime) {
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
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        List<List<Integer>> jobs = new ArrayList<>();

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
