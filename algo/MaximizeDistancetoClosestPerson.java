public class MaximizeDistancetoClosestPerson {
    // Approach 1: Next Array
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else {
                if (i > 0) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = n;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else {
                if (i < n - 1) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = n;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.min(left[i], right[i]));
        }
        return res;
    }
}
