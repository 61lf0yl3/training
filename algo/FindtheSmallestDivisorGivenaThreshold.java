public class FindtheSmallestDivisorGivenaThreshold {
    // Approach 1: Binary Search
    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1000000;
        int res = 1000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            for (int num : nums) {
                if (num % mid == 0) {
                    sum += num / mid;
                } else {
                    sum += (num / mid) + 1;
                }
            }
            if (sum > threshold) {
                low = mid + 1;
            } else {
                res = Math.min(res, mid);
                high = mid;
            }
        }
        return res;
    }
}
