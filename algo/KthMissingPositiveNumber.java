class KthMissingPositiveNumber {
    // Approach 2: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findKthPositive(int[] arr, int k) {
        int[] nums = new int[1001];
        for (int i : arr) {
            nums[i] = 1;
        }
        for (int i = 1; i <= 1000; i++) {
            if (nums[i] == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return k + 1000;
    }
}