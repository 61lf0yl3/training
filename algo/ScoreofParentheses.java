import java.util.Stack;

class ScoreofParentheses {
    // Approach 1: Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(0);
            } else {
                int old = stack.pop();
                int older = stack.pop();
                stack.add(older + Math.max(2 * old, 1));
            }
        }
        return stack.pop();
    }
}