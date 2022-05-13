import java.util.Stack;

class SumofSubarrayRanges {
    // 2104. Sum of Subarray Ranges

    // Approach 1: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public long subArrayRanges(int[] nums) {
        long res = 0;
        long min = 0;
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = nums[i];
            max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }

    // Approach 1: Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public long subArrayRanges2(int[] A) {
        int n = A.length, j, k;
        long res = 0;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long) A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }

        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long) A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }
}