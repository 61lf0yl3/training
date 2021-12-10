import java.util.Stack;

class MinimumRemovetoMakeValidParentheses {
    // 1249. Minimum Remove to Make Valid Parentheses

    // Approach 1: Using a Stack and String Builder
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String minRemoveToMakeValid(String input) {
        Stack<Character> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char top = ' ';
            if (!s.isEmpty()) {
                top = s.peek();
            }
            if (c == ')') {
                if (top == '(') {
                    s.pop();
                    res.append(c);
                }
            } else {
                if (c == '(') {
                    s.add(c);
                }
                res.append(c);
            }
        }
        int i = res.length() - 1;
        while (!s.isEmpty()) {
            if (res.charAt(i) == '(') {
                res.deleteCharAt(i);
                s.pop();
            }
            i--;
        }
        return res.toString();
    }
}