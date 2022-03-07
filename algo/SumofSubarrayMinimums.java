import java.util.ArrayDeque;
import java.util.Deque;
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

    // Approach 1: Using Monotonic Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int sumSubarrayMins2(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        // left bound we set of -1
        stack.push(-1);
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 1 && arr[stack.peek()] > arr[i]) {
                int currElemIndex = stack.pop();
                /*
                 * Note that after the above line, stack.peek() will give us the index of left
                 * next smallest element.
                 * We monotonically order the stack always in an increasing order at all the
                 * times, because of that this
                 * argument holds true.
                 * 'i' will be the next right smallest element index. (The while loop condition
                 * is designed such way).
                 */
                res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * (i - currElemIndex)) % 1000000007;
                res = res % 1000000007;
            }
            stack.push(i);
        }

        // right bound we set to array length;
        int rightBoundary = arr.length;

        while (stack.size() > 1) {
            int currElemIndex = stack.pop();
            res += ((long) arr[currElemIndex] * (currElemIndex - stack.peek()) * (rightBoundary - currElemIndex))
                    % 1000000007;
            res = res % 1000000007;
        }

        return (int) res;

    }
}