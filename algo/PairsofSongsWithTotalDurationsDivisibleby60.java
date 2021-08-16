import java.util.HashMap;
import java.util.Map;

class PairsofSongsWithTotalDurationsDivisibleby60 {
    // 1010. Pairs of Songs With Total Durations Divisible by 60

    // Approach 1: BruteForce;
    // Time complexity : O(N^2)
    // Space complexity : O(1)
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    // Approach 2: HashMap (My version)
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int numPairsDivisibleBy602(int[] time) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] % 60 == 0) {
                res += m.get(0);
            } else {
                if (m.containsKey(60 - time[i] % 60)) {
                    res += m.get(60 - time[i] % 60);
                }
            }

            int key = time[i] % 60;
            if (m.containsKey(key)) {
                m.put(key, m.get(key) + 1);
            } else {
                m.put(key, 1);
            }
        }
        return res;
    }

    // Approach 3: Use an Array to Store Frequencies
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int numPairsDivisibleBy603(int[] time) {
        int[] remainder = new int[60];
        int res = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                res += remainder[t % 60];
            } else {
                res += remainder[60 - t % 60];
            }

            remainder[t % 60]++;
        }
        return res;
    }
}