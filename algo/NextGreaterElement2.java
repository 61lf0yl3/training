import java.util.Stack;

public class NextGreaterElement2 {
    // Approach 2: Monotonus Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[i % n] >= nums[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res[i % n] = -1;
            } else {
                res[i % n] = nums[s.peek()];
            }
            s.push(i % n);
        }
        return res;
    }
}
