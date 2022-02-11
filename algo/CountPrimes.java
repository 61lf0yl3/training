class CountPrimes {

    // Approach 1: Iterative Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] nums = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (!nums[i]) {
                for (int j = i + i; j < n; j += i) {
                    nums[j] = true;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!nums[i]) {
                res++;
            }
        }
        return res++;
    }

}