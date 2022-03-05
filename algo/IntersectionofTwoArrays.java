import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    // Approach 1: Using HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }
        return res;
    }
}
