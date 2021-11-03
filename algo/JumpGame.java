class JumpGame {
    // 55. Jump Game

    // Approach 1: Backtracking (Time Limit Exceeded)
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)
    public boolean canJump(int[] nums) {
        return backtrack(nums, 0);
    }

    public boolean backtrack(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return true;
        } else {
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (backtrack(nums, i)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Approach 2: Backtracking with memororazation (DP Top-down)
// Time Complexity: O(N^2)
// Space Complexity: O(N)
class JumpGame2 {
    int[] memo;
    final int UNKNOWN = 0;
    final int GOOD = 1;
    final int BAD = -1;

    public boolean canJump(int[] nums) {
        memo = new int[nums.length];
        memo[memo.length - 1] = GOOD;
        return backtrack(nums, 0, memo);
    }

    public boolean backtrack(int[] nums, int index, int[] memo) {
        if (memo[index] != UNKNOWN) {
            return memo[index] == GOOD;
        } else {
            for (int i = index + 1; i <= index + nums[index]; i++) {
                if (backtrack(nums, i, memo)) {
                    memo[index] = GOOD;
                    return true;
                }
            }
        }
        memo[index] = BAD;
        return false;
    }
}

    //Approach 3: Backtracking with memororazation (DP Bottom-up)
    //Time Complexity: O(N^2)
    //Space Complexity: O(N)
class JumpGame3 {
    final int UNKNOWN = 0;
    final int GOOD = 1;
    final int BAD = -1;

    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        memo[memo.length - 1] = GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (memo[j] == GOOD) {
                    memo[i] = GOOD;
                    break;
                }
            }
        }
        return memo[0] == GOOD;
    }
}

class JumpGame4 {
    public boolean canJump(int[] nums) {
        int lastGoodPos = nums.length-1;
        for (int i = nums.length-2; i >=0; i--) {
            if (i+nums[i]>= lastGoodPos) {
                lastGoodPos = i;
            }
        }
        return lastGoodPos==0;
    }
}
