public class CapacityToShipPackagesWithinDDays {
    // Approach 1: Iterative Using Binary
    // Time Complexity: O(DlogN)
    // Space Complexity: O(D)
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int max = 0;
        for (int num : weights) {
            sum += num;
            max = Math.max(max, num);
        }

        int lowMax = Math.max(max, sum / days);
        int res = -1;
        while (lowMax <= sum) {
            int mid = lowMax + (sum - lowMax) / 2;
            int[] ships = new int[days];
            int start = 0;
            for (int shipI = 0; shipI < days; shipI++) {
                while (start < n && ships[shipI] + weights[start] <= mid) {
                    ships[shipI] += weights[start++];
                }
            }
            if (start == n) {
                res = mid;
                sum = mid - 1;
            } else {
                lowMax = mid + 1;
            }
        }
        return res;
    }
}
