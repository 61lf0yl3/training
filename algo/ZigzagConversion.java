import java.util.ArrayList;
import java.util.List;

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

    // Approach 2: Sort by Row
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String convert2(String s, int numRows) {

        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows)
            ret.append(row);
        return ret.toString();
    }

    // Approach 3: Visit by Row
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String convert3(String s, int numRows) {

        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}