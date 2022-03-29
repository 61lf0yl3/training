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

    private String digits;
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtrack(0, new StringBuilder());
        return res;
    }

    private void backtrack(int i, StringBuilder comb) {
        if (i >= digits.length()) {
            res.add(comb.toString());
            return;
        }
        for (char c : letters.get(digits.charAt(i)).toCharArray()) {
            comb.append(c);
            backtrack(i + 1, comb);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}