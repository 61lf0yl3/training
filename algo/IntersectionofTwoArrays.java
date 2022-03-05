import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    // Approach 1: Using Two HashSet
    // Time Complexity: O(N+M)
    // Space Complexity: O(N+M)
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

    // Approach 2: Built-in Set Intersection
    // Time Complexity: O(N+M) in average case and O(N*M) in worst case
    // Space Complexity: O(N+M)
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            res[i++] = num;
        }
        return res;
    }
}
