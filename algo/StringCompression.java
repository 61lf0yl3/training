class StringCompression {
    // 443. String Compression

    // Approach 1: Iterative (My version)
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int compress(char[] chars) {
        int res = 0;
        int count = 1;
        char currChar = chars[0];

        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[res++] = currChar;
                if (count > 1) {
                    String countString = String.valueOf(count);
                    for (char c : countString.toCharArray()) {
                        chars[res++] = c;
                    }
                }
                if (i < chars.length) {
                    count = 1;
                    currChar = chars[i];
                }
            } else {
                count++;
            }
        }

        return res;
    }
}