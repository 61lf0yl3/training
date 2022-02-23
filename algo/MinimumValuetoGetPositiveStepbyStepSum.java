public class MinimumValuetoGetPositiveStepbyStepSum {
    // Approach 1: Using Min Prefix
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minStartValue(int[] nums) {
        int minPrefSum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            minPrefSum = Math.min(minPrefSum, sum);
        }
        return Math.abs(minPrefSum) + 1;
    }
}
