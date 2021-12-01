import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    //22. Generate Parentheses

    //Approach #1: Backtrack;
    //Time Complexity: O(4^N/N^1/2)
    //Space Complexity: O(4^N/N^1/2)
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisR(res, n, new StringBuilder(), 0,0);
        return res;
    }
    
    public void generateParenthesisR(List<String> res, int n, StringBuilder comb, int open, int close) {
        if (n*2 == comb.length()) {
                res.add(comb.toString());   
        } else {
            if (open < n) {
                comb.append("(");
                generateParenthesisR(res, n, comb, open+1,close);
                comb.deleteCharAt(comb.length() - 1);
            }
            if ( close < open) {
                comb.append(")");
                generateParenthesisR(res, n, comb, open, close+1);
                comb.deleteCharAt(comb.length() - 1);
            }
        }
    }
    
}

class GenerateParentheses2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}