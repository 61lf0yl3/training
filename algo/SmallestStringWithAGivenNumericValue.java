class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            if (k >= 26 + i) {
                k -= 26;
                chars[i] = 'z';
            } else {
                int temp = k - i;
                chars[i] = (char) (k - i + 'a' - 1);
                k -= temp;
            }
        }
        return String.valueOf(chars);
    }
}