import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String customSortString(String order, String s) {
        ArrayList<Character> aAL = new ArrayList<>();
        for (char c : s.toCharArray()) {
            aAL.add(c);
        }
        int[] chars = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            chars[c - 'a'] = i + 1;
        }
        Collections.sort(aAL, (a, b) -> chars[a - 'a'] - chars[b - 'a']);
        StringBuilder res = new StringBuilder();
        for (Character c : aAL) {
            res.append(c);
        }
        return res.toString();
    }
}