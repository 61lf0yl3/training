class SubarrayProductLessThanK {
    //713. Subarray Product Less Than K

    //Approach #1: Sliding Window
    /**Our loop invariant is that left is the smallest value so that 
     * the product in the window prod = nums[left] * nums[left + 1] * ... * nums[right] is less than k.
     * For every right, we update left and prod to maintain this invariant. 
     * Then, the number of intervals with subarray product less than k and with right-most coordinate right, 
     * is right - left + 1. We'll count all of these for each value of right. */

    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1;
        int ans = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod*=nums[right];
            while (prod>=k) {
                prod /= nums[left];
                left++;
            }
            ans += right - left +1;
        }
        return ans;
    }
}