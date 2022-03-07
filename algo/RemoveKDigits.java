import java.util.Stack;

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
}
