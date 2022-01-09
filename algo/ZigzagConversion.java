import java.util.ArrayList;

class ZigzagConversion {
    // 6. Zigzag Conversion

    // Approach 1: Sort by Row
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String convert(String s, int numRows) {
        if (s.length() == numRows || numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> zigzag = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zigzag.add(new StringBuilder());
        }
        int delimeter = numRows * 2 - 2;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = i % delimeter;
            if (index > numRows - 1) {
                index = delimeter - index;
            }
            zigzag.get(index).append(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(zigzag.get(i));
        }

        return res.toString();
    }
}