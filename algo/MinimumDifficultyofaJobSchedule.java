import java.util.Arrays;

class MinimumDifficultyofaJobSchedule {
    // Approach 1: DP Top-Down
    // Time Complexity: O(N*(N-M)^2)
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

    // Approach 1: DP Bottom-Up
    // Time Complexity: O(N*(N-M)^2)
    // Space Complexity: O(N*(N-M))
    public int minDifficulty2(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1;
        }
        int[][] memo = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        int hardestJob = 0;
        for (int i = n - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            memo[i][d] = hardestJob;
        }

        for (int day = d - 1; day >= 1; day--) {
            for (int i = 0; i < n; i++) {
                int hardest = 0;
                int best = Integer.MAX_VALUE;
                for (int j = i; j < n - (d - day); j++) {
                    hardest = Math.max(hardest, jobDifficulty[j]);
                    best = Math.min(best, hardest + memo[j + 1][day + 1]);
                }
                memo[i][day] = best;
            }
        }

        return memo[0][1];
    }
}