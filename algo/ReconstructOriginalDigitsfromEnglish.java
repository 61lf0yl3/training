import java.util.HashMap;
import java.util.Map;

class Solution {
    // Approach 1: Hashmap
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public String originalDigits(String s) {
        // building hashmap letter -> its frequency
        char[] count = new char[26 + (int) 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        // building hashmap digit -> its frequency
        int[] out = new int[10];
        // letter "z" is present only in "zero"
        out[0] = count['z'];
        // letter "w" is present only in "two"
        out[2] = count['w'];
        // letter "u" is present only in "four"
        out[4] = count['u'];
        // letter "x" is present only in "six"
        out[6] = count['x'];
        // letter "g" is present only in "eight"
        out[8] = count['g'];
        // letter "h" is present only in "three" and "eight"
        out[3] = count['h'] - out[8];
        // letter "f" is present only in "five" and "four"
        out[5] = count['f'] - out[4];
        // letter "s" is present only in "seven" and "six"
        out[7] = count['s'] - out[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        out[9] = count['i'] - out[5] - out[6] - out[8];
        // letter "n" is present in "one", "nine", and "seven"
        out[1] = count['n'] - out[7] - 2 * out[9];

        // building output string
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < out[i]; j++)
                output.append(i);
        return output.toString();
    }

    // Approach 1: Hashmap
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public String originalDigit2(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (int c = 0; c < s.length(); c++) {
            if (!m.containsKey(s.charAt(c))) {
                m.put(s.charAt(c), 1);
            } else {
                m.put(s.charAt(c), m.get(s.charAt(c)) + 1);
            }
        }
        char[] chars = new char[] { 'z', 'w', 'u', 'x', 'g', 'h', 'f', 's', 'i', 'n' };
        int[] nums = new int[] { 0, 2, 4, 6, 8, 3, 5, 7, 9, 1 };
        String[] digits = new String[] { "zero", "two", "four", "six", "eight",
                "three", "five", "seven", "nine", "one", };
        StringBuilder output = new StringBuilder();
        for (int c1 = 0; c1 < chars.length; c1++) {
            if (m.containsKey(chars[c1])) {
                output.append(nums[c1]);
                for (int c2 = 0; c2 < digits[c1].length(); c2++) {
                    m.put(digits[c1].charAt(c2), m.get(digits[c1].charAt(c2)) - 1);
                }
            }
        }
        return output.toString();
    }
}