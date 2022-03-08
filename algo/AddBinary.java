class AddBinary {
    // Approach 1: Bit-by-Bit Computation
    // Time Complexity: O(max(N,M))
    // Space Complexity: O(max(N,M))
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int remainder = 0;
        int j = b.length() - 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            int num1 = a.charAt(i) - '0';
            int num2 = 0;
            if (j >= 0) {
                num2 = b.charAt(j--) - '0';
            }
            sb.append((num1 + num2 + remainder) % 2);
            remainder = (num1 + num2 + remainder) / 2;
        }
        if (remainder == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}