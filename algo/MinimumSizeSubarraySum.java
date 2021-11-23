class MinimumSizeSubarraySum {
    //209. Minimum Size Subarray Sum
    
    //Approach #1: Sliding Window (my version) Two pointer
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int low = 0;
        int high = 0;
        int min = Integer.MAX_VALUE;
        while (low <= high && high < nums.length) {
            sum+=nums[high];
            if (sum>=target) {
                if (min > high-low+1) {
                    min = high-low+1;
                }
                sum = sum - nums[low] - nums[high];
                low++;
                high--;
            }
            high++;
         }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }
}