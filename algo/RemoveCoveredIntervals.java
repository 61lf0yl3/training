import java.util.Arrays;

class RemoveCoveredIntervals {
    // 1288. Remove Covered Intervals

    // Approach 1: Greedy
    // Time Complexity: O(NlogN)
    // Space Complexity: O(logN)
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int prevEnd = 0;
        int res = 0;
        for (int[] curr : intervals) {
            int end = curr[1];
            if (prevEnd < end) {
                prevEnd = end;
                res++;
            }
        }
        return res;
    }
}