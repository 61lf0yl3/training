import java.util.Stack;

class RemoveAllAdjacentDuplicatesinString2 {

    // Approach 1: Using Stack with Pair
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (st.isEmpty() || c != st.peek().getKey()) {
                st.add(new Pair(c, 1));
            } else if (c == st.peek().getKey()) {
                int val = st.peek().getValue();
                st.pop();
                st.add(new Pair(c, val + 1));
            }

            if (st.peek().getValue() == k) {
                st.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            Pair<Character, Integer> p = st.pop();
            for (int i = 0; i < p.getValue(); i++) {
                res.append(p.getKey());
            }
        }
        return res.reverse().toString();
    }
}