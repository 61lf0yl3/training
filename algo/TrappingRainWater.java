public class TrappingRainWater {
    // Approach 1: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }
}
