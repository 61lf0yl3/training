class ContainerWithMostWater {
    //11. Container With Most Water

    //Approach #1: Two pointer
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int max = 0;
        while (low <= high) {
            int temp = (high - low)*Math.min(height[low],height[high]);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}