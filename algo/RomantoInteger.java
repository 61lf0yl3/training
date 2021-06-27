import java.util.HashMap;
import java.util.Map;

class RomantoInteger {
    // 13. Roman to Integer
    static Map<Character, Integer> values = new HashMap<>();

    // Approach 1: Iterative (My version)
    // Time complexity : O(1)
    // Space complexity : O(1)
    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 1 &&
                    ((c == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) ||
                            (c == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ||
                            (c == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')))) {
                res += values.get(s.charAt(i + 1)) - values.get(c);
                i++;
            } else {
                res += values.get(c);
            }
        }
        return res;
    }
}