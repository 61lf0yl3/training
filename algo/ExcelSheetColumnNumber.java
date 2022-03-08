class ExcelSheetColumnNumber {
    // Approach 1: Right to Left
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length();
        for (int i = n - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            res += (num * (Math.pow(26, n - i - 1)));
        }
        return res;
    }
}