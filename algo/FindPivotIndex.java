class FindPivotIndex {
    // Approach 2: Prefix Sum
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

    // Approach 2: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int pivotIndex2(int[] nums) {
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