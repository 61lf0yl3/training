class JumpGame2 {
    
    public int jump(int[] nums) {
        int res = 0;
        int farthest = 0;
        int currentJumpEnd = 0;
        for (int i = 0; i<nums.length-1;i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(i+nums[i], farthest);
            
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                res++;
                currentJumpEnd = farthest;
            }
        }
        return res;
    }
}