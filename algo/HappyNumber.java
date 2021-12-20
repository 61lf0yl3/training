import java.util.Arrays;
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

    // Approach 2: Floyd's Cycle-Finding Algorithm
    // slow runner goes forward by 1 number in the chain,
    // and the fast runner goes forward by 2 numbers
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNextN(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNextN(slowRunner);
            fastRunner = getNextN(getNextN(fastRunner));
        }
        return fastRunner == 1;
    }

    //// Approach 3: Hardcoding the Only Cycle
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    //
    private static Set<Integer> cycleMembers = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public boolean isHappy3(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNextN(n);
        }
        return n == 1;
    }

}