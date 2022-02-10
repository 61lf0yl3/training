public class MissingNumber {
    // Approach 1: Iterative
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
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
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
