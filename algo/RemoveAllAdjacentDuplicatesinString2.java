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

    // Approach 1: Memoise Count
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String removeDuplicates4(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        int[] count = new int[s.length()];
        for (int i = 0; i < res.length(); i++) {
            if (i == 0 || res.charAt(i) != res.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    res.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return res.toString();
    }
}
