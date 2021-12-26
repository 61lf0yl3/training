import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LetterCombinationsofaPhoneNumber {

    // Approach #1: Backtrack with hashmap;
    // Time Complexity: O(4^N)
    // Space Complexity: O(N)
    private Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(digits, res, new StringBuilder(), 0);
        return res;
    }

    public void backtrack(String digits, List<String> res, StringBuilder comb, int start) {
        if (comb.length() == digits.length()) {
            res.add(comb.toString());
        } else {
            String c = letters.get(digits.charAt(start));
            for (int i = 0; i < c.length(); i++) {
                comb.append(c.charAt(i));
                backtrack(digits, res, comb, start + 1);
                comb.deleteCharAt(comb.length() - 1);
            }
        }
    }
}