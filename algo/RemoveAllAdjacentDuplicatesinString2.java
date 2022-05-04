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

    // Approach 2: Two Pointers
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String removeDuplicates2(String s, int k) {
        char[] sa = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++, j++) {
            sa[j] = sa[i];
            if (j == 0 || sa[j] != sa[j - 1]) {
                stack.add(1);
            } else {
                int incremented = stack.pop() + 1;
                if (incremented == k) {
                    j = j - k;
                } else {
                    stack.add(incremented);
                }
            }
        }
        return new String(sa, 0, j);
    }

    // Approach 3: Using Stack
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String removeDuplicates3(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < res.length(); i++) {
            if (i == 0 || res.charAt(i) != res.charAt(i - 1)) {
                stack.add(1);
            } else {
                int incremented = stack.pop() + 1;
                if (incremented == k) {
                    res.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.add(incremented);
                }
            }
        }
        return res.toString();
    }

    // Approach 2: Memoise Count
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

    public String removeDuplicates5(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (!stack.isEmpty() && curr == stack.peek().getKey()) {
                Pair<Character, Integer> newPair = new Pair<>(curr, stack.peek().getValue() + 1);
                stack.pop();
                stack.add(newPair);
            } else {
                stack.add(new Pair<>(curr, 1));
            }
            if (stack.peek().getValue() == k) {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        for (Pair<Character, Integer> p : stack) {
            for (int i = 0; i < p.getValue(); i++) {
                res.append(p.getKey());
            }
        }
        return res.toString();
    }
}
