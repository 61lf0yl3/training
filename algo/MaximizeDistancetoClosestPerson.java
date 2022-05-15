public class MaximizeDistancetoClosestPerson {
    // 849. Maximize Distance to Closest Person

    // Approach 1: Next Array
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        if (seats[0] == 0) {
            left[0] = n;
        }
        for (int i = 1; i < n; i++) {
            if (seats[i] == 1) {
                left[i] = 0;
            } else {
                left[i] = left[i - 1] + 1;
            }
        }

        int[] right = new int[n];
        if (seats[n - 1] == 0) {
            right[n - 1] = n;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (seats[i] == 1) {
                right[i] = 0;
            } else {
                right[i] = right[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.min(left[i], right[i]));
        }
        return res;
    }
}
