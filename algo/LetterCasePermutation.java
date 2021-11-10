import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {

    //Approach #1: Recursion
    //Time Complexity: O(2^N*N)
    //Space Complexity: O(2^N*N)
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> tempRes = new ArrayList<>();
        tempRes.add(new StringBuilder());
        
        for (char c: s.toCharArray()) {
            int n = tempRes.size();
            if (Character.isLetter(c)) {
                for (int i=0; i<n; i++) {
                    // add copy of curr string
                    tempRes.add(new StringBuilder(tempRes.get(i)));
                    //add lower case to curr in first half
                    tempRes.get(i).append(Character.toLowerCase(c));
                    //add upper case to curr in other half
                    tempRes.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    // add non-letter to each string of Arraylist of string
                    tempRes.get(i).append(c);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        // copy to res from StringBuilder to String
        for (StringBuilder sb : tempRes) {
            res.add(sb.toString());
        }
        return res;
    }
}