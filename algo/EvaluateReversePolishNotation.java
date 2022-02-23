import java.util.Stack;

public class EvaluateReversePolishNotation {
    // Approach 1: Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("*")) {
                int nb2 = s.pop();
                int nb1 = s.pop();
                s.add(nb1 * nb2);
            } else if (tokens[i].equals("/")) {
                int nb2 = s.pop();
                int nb1 = s.pop();
                s.add(nb1 / nb2);
            } else if (tokens[i].equals("+")) {
                int nb2 = s.pop();
                int nb1 = s.pop();
                s.add(nb1 + nb2);
            } else if (tokens[i].equals("-")) {
                int nb2 = s.pop();
                int nb1 = s.pop();
                s.add(nb1 - nb2);
            } else {
                s.add(Integer.parseInt(tokens[i]));
            }
        }
        return s.peek();
    }
}
