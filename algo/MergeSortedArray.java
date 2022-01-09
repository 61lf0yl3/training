import java.util.Arrays;

class MergeSortedArray {
    // 88. Merge Sorted Array

    // Approach 1: Two Pointer
    // Time Complexity: O(m+n)
    // Space Complexity: O(m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == m) {
            return;
        }
        int[] nums = Arrays.copyOfRange(nums1, 0, m);

        int j1 = 0;
        int j2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (j1 < m && j2 < n) {
                if (nums[j1] < nums2[j2]) {
                    nums1[i] = nums[j1++];
                } else {
                    nums1[i] = nums2[j2++];
                }
            } else if (j1 < m) {
                nums1[i] = nums[j1++];
            } else if (j2 < n) {
                nums1[i] = nums2[j2++];
            }
        }
    }
}