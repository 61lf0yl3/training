import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    // 202. Happy Number

    // Approach 1: Detect Cycles with a HashSet
    // Time Complexity: O(logN)
    // Space Complexity: O(logN)
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (n != 1 && !s.contains(n)) {
            s.add(n);
            n = getNextN(n);
        }
        return n == 1;
    }

    public int getNextN(int n) {
        int total = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            total += d * d;
        }
        return total;
    }

}