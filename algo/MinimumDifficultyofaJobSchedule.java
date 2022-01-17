import java.util.Arrays;

class MinimumDifficultyofaJobSchedule {
    // Approach 1: DP Top-Down
    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    int n;
    int d;
    int[] jobDifficulty;
    int[][] memo;
    int[] hardestJobDifficulty;

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        this.jobDifficulty = jobDifficulty;
        this.d = d;
        memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        hardestJobDifficulty = new int[n];
        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobDifficulty[i] = hardestJob;
        }
        return minDifficultyDP(0, 1);
    }

    public int minDifficultyDP(int i, int day) {
        if (day == d) {
            return hardestJobDifficulty[i];
        }
        if (memo[i][day] == -1) {
            int best = Integer.MAX_VALUE;
            int hardest = 0;
            for (int j = i; j < n - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                best = Math.min(best, hardest + minDifficultyDP(j + 1, day + 1));
            }
            memo[i][day] = best;
        }
        return memo[i][day];
    }
}