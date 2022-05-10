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

    // Approach 1: Sliding Window
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public List<Integer> sequentialDigits2(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int length = lowLen; length < highLen + 1; ++length) {
            for (int start = 0; start < n - length; ++start) {
                int num = Integer.parseInt(sample.substring(start, start + length));
                if (num >= low && num <= high)
                    nums.add(num);
            }
        }
        return nums;
    }
}