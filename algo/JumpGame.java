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

class JumpGame2 {
    int[] memo; 
    final int UNKNOWN =0;
    final int GOOD =1;
    final int BAD =-1;
    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        memo[memo.length-1]=GOOD;
        return backtrack(nums, 0, memo);
    }
    
    public boolean backtrack(int[] nums, int index, int[] memo) {
        if (memo[index]!=UNKNOWN) {
            return memo[index]==GOOD;
        } else {
            for (int i = index+1; i<= index+nums[index]; i++) {
                if (backtrack(nums, i,memo)){
                    memo[index]=GOOD;
                    return true;
                }
            }
        }
        memo[index]=BAD;
        return false;
    }
}