class ThekthFactorofn {
    // Approach 1: Brute Force
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}