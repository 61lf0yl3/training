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

class GenerateParentheses3 {
    //Approach 1: Brute Force
    //Time Complexity: O(2^2N*N)
    //Space Complexity: O(2^2N*N)
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisR(res, 0, new char[2*n]);
        return res;
    }
    
    public void generateParenthesisR(List<String> res, int index, char[] comb) {
        if (index == comb.length) {
            if (validParenthesis(comb)) {
                res.add(new String(comb));   
            }
        } else {
            comb[index] = '(';
            generateParenthesisR(res, index+1, comb);
            comb[index] = ')';
            generateParenthesisR(res, index+1, comb);
        }
    }
    
    public boolean validParenthesis(char[] comb) {
        int sum = 0;
        for (int i = 0; i<comb.length; i++) {
            if ( comb[i]=='(' ){
                sum++;
            } else {
                sum--;
            }
            if (sum<0) {
                return false;
            }
        }
        return sum==0;
    }
}