import java.util.Stack;

class MinimumAddtoMakeParenthesesValid {
    // 921. Minimum Add to Make Parentheses Valid

    // Approach 1: Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (top == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
            }
            stack.add(c);
        }
        return stack.size();
    }

    // Approach 2: Using Balance
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int minAddToMakeValid2(String s) {
        int balance = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == -1) {
                res++;
                balance++;
            }
        }
        return res + balance;
    }
}