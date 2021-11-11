class Solution {
    // Approach 1: Recursion with Memoization;
    // Time complexity: O(N)
    // Space complexity : O(N)
    public int rob(int[] nums) {
        int[] memory = new int[nums.length + 1];
        Arrays.fill(memory, -1);
        return robR(nums, 0, memory);
    }

    public int robR(int[] nums, int index, int[] memory) {
        if (index >= nums.length) {
            return 0;
        }
        if (memory[index] != -1) {
            return memory[index];
        }
        memory[index] = Math.max(robR(nums, index + 1, memory), robR(nums, index + 2, memory) + nums[index]);
        return memory[index];
    }

    //Approach 2: Dynamic Programming
    // Time complexity: O(N)
    // Space complexity : O(N)
    public int rob2(int[] nums) {
        int[] memory = new int[nums.length + 1];
        memory[0] = 0;
        memory[1] = nums[0];
        for (int i = 2; i < memory.length; i++) {
            memory[i] = Math.max(memory[i - 2] + nums[i - 1], memory[i - 1]);
        }
        return memory[nums.length];
    }
}