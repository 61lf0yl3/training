import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    // 22. Generate Parentheses

    // Approach #1: Backtrack;
    // Time Complexity: O(4^N/N^1/2)
    // Space Complexity: O(4^N/N^1/2)
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, n, new StringBuilder());
        return res;
    }

    private void backtrack(int open, int close, StringBuilder comb) {
        if (open == 0 && close == 0) {
            res.add(comb.toString());
            return;
        }
        if (0 < open && open <= close) {
            comb.append('(');
            backtrack(open - 1, close, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
        if (0 < close && close > open) {
            comb.append(')');
            backtrack(open, close - 1, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
    }

}

class GenerateParentheses3 {
    // Approach 1: Brute Force
    // Time Complexity: O(2^2N*N)
    // Space Complexity: O(2^2N*N)
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisR(res, 0, new char[2 * n]);
        return res;
    }

    public void generateParenthesisR(List<String> res, int index, char[] comb) {
        if (index == comb.length) {
            if (validParenthesis(comb)) {
                res.add(new String(comb));
            }
        } else {
            comb[index] = '(';
            generateParenthesisR(res, index + 1, comb);
            comb[index] = ')';
            generateParenthesisR(res, index + 1, comb);
        }
    }

    public boolean validParenthesis(char[] comb) {
        int sum = 0;
        for (int i = 0; i < comb.length; i++) {
            if (comb[i] == '(') {
                sum++;
            } else {
                sum--;
            }
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }
}