import java.util.Stack;
import java.util.LinkedList;

public class RemoveKDigits {
    // Approach 1: Using Greedy with Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int i = 0;
        s.add(num.charAt(i++));
        while (i < num.length() && k > 0) {
            if (s.isEmpty()) {
                s.add(num.charAt(i++));
                continue;
            }
            if (s.peek() <= num.charAt(i)) {
                s.add(num.charAt(i++));
            } else {
                s.pop();
                k--;
            }
        }
        while (k > 0) {
            s.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        res.reverse();
        for (int j = i; j < num.length(); j++) {
            res.append(num.charAt(j));
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (i = 0; i < res.length(); i++) {
            char digit = res.charAt(i);
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string */
        if (ret.length() == 0)
            return "0";
        return ret.toString();
    }

    public String removeKdigits2(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string */
        if (ret.length() == 0)
            return "0";
        return ret.toString();
    }
}
