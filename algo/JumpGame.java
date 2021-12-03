class JumpGame {
    //55. Jump Game

    //Approach 1: Backtracking (Time Limit Exceeded)
    //Time Complexity: O(2^N)
    //Space Complexity: O(N)
    public boolean canJump(int[] nums) {
        return backtrack(nums, 0);
    }
    
    public boolean backtrack(int[] nums, int index) {
        if (index >= nums.length-1) {
            return true;
        } else {
            for (int i = index+1; i<= index+nums[index]; i++) {
                if (backtrack(nums, i)){
                    return true;
                }
            }
        }
        return false;
    }
}
