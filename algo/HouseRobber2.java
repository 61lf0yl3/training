class HouseRobber2 {
    //213. House Robber II

    //pproach 1: Dynamic Programming
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public int rob(int[] nums) {
        int oldest = 0;
        int old1 = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(oldest + nums[i - 1], old1);
            oldest = old1;
            old1 = curr;
        }
        oldest = 0;
        int old2 = 0;
        if (nums.length>1) {
            old2 = nums[1];
            for (int i = 3; i <= nums.length; i++) {
                int curr = Math.max(oldest + nums[i - 1], old2);
                oldest = old2;
                old2 = curr;
            }
        }
        return Math.max(old1,old2);
    }
}