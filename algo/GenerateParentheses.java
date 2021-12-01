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