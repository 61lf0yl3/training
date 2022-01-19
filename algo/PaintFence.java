class PaintFence {
    // Approach 1: DP Bottom-Up (Tabulation) Constant Space
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        int[] dp = new int[n + 1];
        int oldest = k;
        int old = k * k;
        for (int i = 3; i <= n; i++) {
            int curr = (k - 1) * (oldest + old);
            oldest = old;
            old = curr;
        }
        return old;
    }
}