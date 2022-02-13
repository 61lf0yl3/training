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

    // Approach 1: Array, Optimized Space
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        int hotest = temperatures[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int curr = temperatures[i];
            if (curr >= hotest) {
                hotest = curr;
            } else {
                int days = 1;
                while (curr >= temperatures[i + days]) {
                    days += res[i + days];
                }
                res[i] = days;
            }
        }
        return res;
    }
}
