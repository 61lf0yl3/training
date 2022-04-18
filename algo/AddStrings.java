class AddStrings {
    // 415. Add Strings

    // Approach 1: Elementary Math
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();
        int remainder = 0;
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        while (i1 >= 0 || i2 >= 0) {
            int d1 = 0;
            int d2 = 0;
            if (i1 >= 0) {
                d1 = num1.charAt(i1--) - '0';
            }
            if (i2 >= 0) {
                d2 = num2.charAt(i2--) - '0';
            }
            res.append((d1 + d2 + remainder) % 10);
            remainder = (d1 + d2 + remainder) / 10;
        }
        if (remainder > 0) {
            res.append(remainder);
        }
        return res.reverse().toString();
    }
}