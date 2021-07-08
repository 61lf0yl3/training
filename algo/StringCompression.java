class StringCompression {
    // 443. String Compression

    // Approach 1: Iterative (My version)
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int compress(char[] chars) {
        int compressIndex = 0;
        int charCount = 1;
        char currChar = chars[0];
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[compressIndex++] = currChar;
                if (charCount > 1) {
                    String count = Integer.toString(charCount);
                    for (char digit : count.toCharArray()) {
                        chars[compressIndex++] = digit;
                    }
                }
                if (i < chars.length) {
                    charCount = 1;
                    currChar = chars[i];
                }
            } else {
                charCount++;
            }
        }
        return compressIndex;
    }
}