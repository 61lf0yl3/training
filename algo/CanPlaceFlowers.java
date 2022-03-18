class CanPlaceFlowers {
    // Approach 1: Single Scan
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = false;
                if (i == 0 || flowerbed[i - 1] == 0) {
                    emptyLeftPlot = true;
                }
                boolean emptyRightPlot = false;
                if (i == m - 1 || flowerbed[i + 1] == 0) {
                    emptyRightPlot = true;
                }
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}