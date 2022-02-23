public class MinimumValuetoGetPositiveStepbyStepSum {
    // Approach 1: Using Min Prefix
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minStartValue(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.min(res, sum);
        }
        return Math.abs(res) + 1;
    }

    // Approach 1: Binary Search
    // Time Complexity: O(Nlog100*N)
    // Space Complexity: O(1)
    public int minStartValue2(int[] nums) {
        // int res = 0;
        int low = 1;
        int high = nums.length * 100;
        while (low < high) {
            boolean isValid = true;
            int mid = low + (high - low) / 2;
            int sum = mid;
            for (int num : nums) {
                sum += num;
                if (sum < 1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                // res = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
