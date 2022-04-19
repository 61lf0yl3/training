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

    // Approach 1: Count Cores
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int scoreOfParentheses2(String s) {
        int res = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else {
                balance--;
                if (s.charAt(i - 1) == '(') {
                    res += 1 << balance;
                }
            }
        }
        return res;
    }
}