import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {
    // Approach 1: Mark Visited Elements in the Input Array itself
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            res.add(0);
        }
        for (int num : nums) {
            res.set(num, res.get(num) + 1);
        }
        int j = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (res.get(i) == 2) {
                count++;
                res.set(j++, i);
                res.set(i, 1);
            }
        }
        return res.subList(0, count);
    }
}
