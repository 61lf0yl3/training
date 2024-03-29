class ProductofArrayExceptSelf {
    // 238. Product of Array Except Self

    // Approach 1: Left and Right product lists
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[n];
        right[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    // Approach 2: O(1) space approach
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;

        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }

        return res;
    }
}