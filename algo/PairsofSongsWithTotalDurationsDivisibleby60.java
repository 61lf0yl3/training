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
}