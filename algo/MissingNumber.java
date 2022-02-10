public class MissingNumber {
    // Approach 1: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    // Approach 1: Gauss' Formula [Accepted]
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    // Approach #3 Bit Manipulation [Accepted]
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
