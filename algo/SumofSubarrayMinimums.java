import java.util.Stack;

class SumofSubarrayMinimums {

    // Approach 1: Using Monotonic Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;
        Stack<Integer> s = new Stack<>();

        s.add(-1);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (s.size() > 1 && arr[s.peek()] > arr[i]) {
                int curr = s.pop();
                res += (long) arr[curr] * (curr - s.peek()) * (i - curr);
                res %= MOD;
            }
            s.push(i);
        }

        int rightBoundary = arr.length;
        while (s.size() > 1) {
            int curr = s.pop();
            res += (long) arr[curr] * (curr - s.peek()) * (rightBoundary - curr);
            res %= MOD;
        }
        return (int) res;
    }
}