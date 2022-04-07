import java.util.Arrays;

class MergeSortedArray {
    // 88. Merge Sorted Array

    // Approach 1: Two Pointer from the Back
    // Time Complexity: O(m+n)
    // Space Complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == m) {
            return;
        }

        int j1 = m - 1;
        int j2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {
            if (j1 >= 0 && j2 >= 0) {
                if (nums1[j1] > nums2[j2]) {
                    nums1[i] = nums1[j1--];
                } else {
                    nums1[i] = nums2[j2--];
                }
            } else if (j1 >= 0) {
                nums1[i] = nums1[j1--];
            } else if (j2 >= 0) {
                nums1[i] = nums2[j2--];
            }
        }
    }

    // Approach 2: Two Pointer
    // Time Complexity: O(m+n)
    // Space Complexity: O(m)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
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

        /*
         * OR
         * Compare elements from nums1Copy and nums2 and write the smallest to nums1.
         * for (int p = 0; p < m + n; p++) {
         * // We also need to ensure that p1 and p2 aren't over the boundaries
         * // of their respective arrays.
         * if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
         * nums1[p] = nums1Copy[p1++];
         * } else {
         * nums1[p] = nums2[p2++];
         * }
         * }
         */
    }

    // Approach 1: Two Pointer from the Back
    // Time Complexity: O(m+n)
    // Space Complexity: O(1)
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}