import java.util.HashMap;
import java.util.Map;

class FractiontoRecurringDecimal {
    // 166. Fraction to Recurring Decimal

    // Approach 1: Long Division
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            res.append("-");
        }

        long num = Math.abs(Long.valueOf(numerator));
        long denom = Math.abs(Long.valueOf(denominator));

        res.append(String.valueOf(num / denom));
        long remainder = num % denom;
        if (remainder == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> m = new HashMap<>();

        while (remainder > 0) {
            if (m.containsKey(remainder)) {
                res.insert(m.get(remainder), "(");
                res.append(")");
                break;
            }
            m.put(remainder, res.length());
            remainder *= 10;
            res.append(String.valueOf(remainder / denom));
            remainder %= denom;
        }

        return res.toString();
    }

}