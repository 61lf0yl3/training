import java.util.ArrayDeque;
import java.util.Deque;

class MaximumSumCircularSubarray {
    // Approach 1: Kadane's (Sign Variant)
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    int[] nums;

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int res1 = kadane(0, n - 1, 1);
        int res2 = sum + kadane(1, n - 1, -1);
        int res3 = sum + kadane(0, n - 2, -1);
        return Math.max(res1, Math.max(res2, res3));
    }

    private int kadane(int start, int end, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int max = sign * nums[start];
        int curr = sign * nums[start];
        for (int i = start + 1; i <= end; i++) {
            curr = sign * nums[i] + Math.max(curr, 0);
            max = Math.max(max, curr);
        }
        return max;
    }

    // Approach 2: Prefix Sums + Monoqueue
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxSubarraySumCircular2(int[] A) {
        int N = A.length;

        // Compute P[j] = B[0] + B[1] + ... + B[j-1]
        // for fixed array B = A+A
        int[] P = new int[2 * N + 1];
        for (int i = 0; i < 2 * N; ++i)
            P[i + 1] = P[i] + A[i % N];

        // Want largest P[j] - P[i] with 1 <= j-i <= N
        // For each j, want smallest P[i] with i >= j-N
        int ans = A[0];
        // deque: i's, increasing by P[i]
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);

        for (int j = 1; j <= 2 * N; ++j) {
            // If the smallest i is too small, remove it.
            if (deque.peekFirst() < j - N)
                deque.pollFirst();

            // The optimal i is deque[0], for cand. answer P[j] - P[i].
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);

            // Remove any i1's with P[i2] <= P[i1].
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(j);
        }

        return ans;
    }
}