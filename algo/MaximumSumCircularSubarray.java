class MaximumSumCircularSubarray {
    // Approach 1: Kadane's (Sign Variant)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    int[] nums;

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res1 = kadane(0, n - 1, 1);
        int res2 = sum + kadane(1, n - 1, -1);
        int res3 = sum + kadane(0, n - 2, -1);
        return Math.max(res1, Math.max(res2, res3));
    }

    private int kadane(int start, int end, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int max = sign * nums[start];
        int curr = sign * nums[start];
        for (int i = start + 1; i <= end; i++) {
            curr = sign * nums[i] + Math.max(curr, 0);
            max = Math.max(max, curr);
        }
        return max;
    }

}