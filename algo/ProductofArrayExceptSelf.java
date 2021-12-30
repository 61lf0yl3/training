class ProductofArrayExceptSelf {
    // 238. Product of Array Except Self

    // Approach 1: Left and Right product lists
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    // Approach 2: O(1) space approach
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}