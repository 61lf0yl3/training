import java.util.Stack;

// Approach 1: Stack of Value/ Minimum Pairs;
// Time Complexity: O(1)
// Space Complexity: O(N)
public class MinStack {
    Stack<int[]> s;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        if (!s.isEmpty() && val > s.peek()[1]) {
            s.add(new int[] { val, s.peek()[1] });
        } else {
            s.add(new int[] { val, val });
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
    }
}
