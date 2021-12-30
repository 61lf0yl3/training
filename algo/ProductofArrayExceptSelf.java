class ProductofArrayExceptSelf {
    // 238. Product of Array Except Self

    // Approach 2: O(1) space approach
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int[] productExceptSelf(int[] nums) {
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