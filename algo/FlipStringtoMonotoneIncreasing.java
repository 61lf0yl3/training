class FlipStringtoMonotoneIncreasing {
    // 926. Flip String to Monotone Increasing

    // Approach 1: Prefix Sums
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N - j - (P[N] - P[j]));
        }

        return ans;
    }
}