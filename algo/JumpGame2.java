class JumpGame2 {
    // 45. Jump Game II

    // Approach 4: Greedy
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int jump(int[] nums) {
        int res = 0;
        int maxJump = 0;
        int currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            maxJump = Math.max(maxJump, i + nums[i]);

            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentEnd) {
                res++;
                currentEnd = maxJump;
            }
        }
        return res;
    }

    // Approach 1: Recursive;
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int res;

    public int jump2(int[] nums) {
        res = Integer.MAX_VALUE;
        jumpR(nums, 0, 0);
        return res;
    }

    private void jumpR(int[] nums, int index, int step) {
        if (index >= nums.length - 1) {
            res = Math.min(res, step);
            return;
        }
        for (int i = index + 1; i <= index + nums[index]; i++) {
            jumpR(nums, i, step + 1);
        }
    }
}