import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    // Approach 1: Using Stack;
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    // Approach 1: Using Stack;
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String removeDuplicates2(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (res.length() > 0 && res.charAt(res.length() - 1) == c) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
