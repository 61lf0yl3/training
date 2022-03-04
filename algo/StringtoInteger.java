public class StringtoInteger {
    public int myAtoi(String s) {
        int SIGN = 1;
        int res = 0;
        int i = 0;
        int n = s.length();

        // Discard all spaces from the beginning of the input string.
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (i < n && s.charAt(i) == '+') {
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            SIGN = -1;
            i++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';

            // Check overflow and underflow conditions.
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return SIGN == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // Append current digit to the result.
            res = res * 10 + d;
            i++;
        }
        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return res * SIGN;
    }
}
