import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParentheses {
    // 20. Valid Parentheses

    // Approach 1: Stacks
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean isValid(String s) {
        Stack<Character> stck = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char top = ' ';
            if (!stck.isEmpty()) {
                top = stck.peek();
            }
            if (c == '(' || c == '{' || c == '[') {
                stck.add(c);
            } else if (c == ')' && top == '(') {
                stck.pop();
            } else if (c == '}' && top == '{') {
                stck.pop();
            } else if (c == ']' && top == '[') {
                stck.pop();
            } else {
                return false;
            }
        }
        return stck.isEmpty();
    }

    public boolean isValid2(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('(', 0);
        m.put('{', 0);
        m.put('[', 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            } else if (s.charAt(i) == ')') {
                if (m.get('(') == 0) {
                    return false;
                } else {
                    m.put('(', m.get('(') - 1);
                }
            } else if (s.charAt(i) == '}') {
                if (m.get('{') == 0) {
                    return false;
                } else {
                    m.put('{', m.get('{') - 1);
                }
            } else if (s.charAt(i) == ']') {
                if (m.get('[') == 0) {
                    return false;
                } else {
                    m.put('[', m.get('[') - 1);
                }
            }
        }
        if (m.get('(') != 0 || m.get('{') != 0 || m.get('[') != 0) {
            return false;
        }
        return true;
    }
}