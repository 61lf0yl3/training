class MaximumScorefromPerformingMultiplicationOperations {
    int[] nums;
    int[] multipliers;
    int[][] memo;
    int n;
    int m;

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        memo = new int[m][m];
        return maximumScoreDP(0, 0);
    }

    public int maximumScoreDP(int i, int left) {
        if (i >= m) {
            return 0;
        }
        int mult = multipliers[i];
        int right = n - 1 - (i - left);
        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(mult * nums[left] + maximumScoreDP(i + 1, left + 1),
                    mult * nums[right] + maximumScoreDP(i + 1, left));
        }
        return memo[i][left];
    }
}