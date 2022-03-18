class FindPivotIndex {
    // Approach 1: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = sum;
            sum += nums[i];
        }

        sum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = sum;
            sum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}