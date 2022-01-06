class IntegertoRoman {
    // 12. Integer to Roman

    // Approach 1: Greedy
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(symbols[i]);
            }
        }
        return res.toString();
    }
}