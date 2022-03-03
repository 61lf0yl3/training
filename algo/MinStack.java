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

// Approach 1: Two Stacks
// Time Complexity: O(1)
// Space Complexity: O(N)
class MinStack2 {

    Stack<Integer> s;
    Stack<Integer> min;

    public MinStack2() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        s.add(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.add(val);
        }
    }

    public void pop() {
        if (s.peek() <= min.peek()) {
            min.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
