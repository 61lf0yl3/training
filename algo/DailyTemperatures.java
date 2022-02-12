import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    // Approach 1: Monotonic Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int top = s.pop();
                res[top] = i - top;
            }
            s.push(i);
        }
        return res;
    }
}
