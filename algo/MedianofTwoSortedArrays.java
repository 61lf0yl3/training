class MedianofTwoSortedArrays {

    // Approach 1: Devide and Conquer
    // Time complexity : O(log(N+M))
    // Space complexity : O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int low1 = 0;
        int high1 = nums1.length - 1;
        int low2 = 0;
        int high2 = nums2.length - 1;
        if (high1 == -1) {
            return median(nums2, low2, high2);
        }
        if (high2 == -1) {
            return median(nums1, low1, high1);
        }
        return findMedianSortedArrays(nums1, low1, high1, nums2, low2, high2);
    }

    private double findMedianSortedArrays(int[] nums1, int low1, int high1, int[] nums2, int low2, int high2) {
        if (low1 == high1 && low2 == high2) {
            return (nums1[low1] + nums2[low2]) / 2.0;
        }
        double mid1 = median(nums1, low1, high1);
        double mid2 = median(nums2, low2, high2);

        if (mid1 == mid2) {
            return mid1;
        } else if (mid1 < mid2) {
            if ((high1 - low1) % 2 == 0) {
                low1 = (low1 + high1) / 2;
            } else {
                low1 = ((low1 + high1) / 2) + 1;
            }
            high2 = (low2 + high2) / 2;
        } else {
            if ((high2 - low2) % 2 == 0) {
                low2 = (low2 + high2) / 2;
            } else {
                low2 = ((low2 + high2) / 2) + 1;
            }
            high1 = (low1 + high1) / 2;
        }
        return findMedianSortedArrays(nums1, low1, high1, nums2, low2, high2);
    }

    private double median(int[] nums, int low, int high) {
        double mid;
        if ((high - low) % 2 == 0) {
            mid = nums[(low + high) / 2];
        } else {
            mid = (nums[(low + high) / 2] + nums[((low + high) / 2) + 1]) / 2.0;
        }
        return mid;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }

        if (nums1 == null) {
            int n = nums2.length;
            return nums2[(n - 1) / 2] * 0.5 + nums2[n / 2] * 0.5;
        }

        if (nums2 == null) {
            int n = nums1.length;
            return nums1[(n - 1) / 2] * 0.5 + nums1[n / 2] * 0.5;
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // choose shorter to binary search
        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;

        while (left < right) {
            int i = (left + right) / 2;
            int j = (n + m) / 2 - i;

            if (nums1[i] < nums2[j - 1]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int first = left;
        int second = (n + m) / 2 - left;

        int shorterLeft = first == 0 ? Integer.MIN_VALUE : nums1[first - 1];
        int shorterRight = first == n ? Integer.MAX_VALUE : nums1[first];

        int longerLeft = second == 0 ? Integer.MIN_VALUE : nums2[second - 1];
        int longerRight = second == m ? Integer.MAX_VALUE : nums2[second];

        if ((n + m) % 2 == 1) {
            return Math.min(shorterRight, longerRight);
        } else {
            return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
        }

    }
}