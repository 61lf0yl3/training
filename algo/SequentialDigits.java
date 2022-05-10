import java.util.ArrayList;
import java.util.List;

class SequentialDigits {
    // 1291. Sequential Digits

    // Approach 1: Sliding Window
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int length = 1; length <= 9; length++) {
            for (int start = 1; start <= 9 - length; start++) {
                int num = 0;
                for (int i = start; i <= start + length; i++) {
                    num *= 10;
                    num += i;
                }
                if (low <= num && num <= high) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}