class ContainerWithMostWater {
    // 11. Container With Most Water

    // Approach #1: Two pointer
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int maxArea(int[] height) {
        int n = height.length;
        int low = 0;
        int high = n - 1;
        int res = 0;
        while (low < high) {
            int temp = (high - low) * Math.min(height[low], height[high]);
            res = Math.max(res, temp);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }
}