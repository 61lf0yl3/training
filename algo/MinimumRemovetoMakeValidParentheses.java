import java.util.HashSet;
import java.util.Set;
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

    // Approach 2: Two Pass String Builder
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String minRemoveToMakeValid2(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            }
            if (c == close) {
                if (balance == 0)
                    continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }

    // Approach 3: Using a Stack and String Builder
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String minRemoveToMakeValid3(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    // Approach 4: Shortened Two Pass String Builder
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String minRemoveToMakeValid4(String s) {

        // Pass 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            }
            if (c == ')') {
                if (balance == 0)
                    continue;
                balance--;
            }
            sb.append(c);
        }

        // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0)
                    continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}