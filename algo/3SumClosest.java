class 3SumClosest {
    //16. 3Sum Closest

    // Approach 1: Brute Force
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int nb1 = 0; nb1 < nums.length; nb1++) {
            for (int nb2 = nb1 + 1; nb2 < nums.length; nb2++) {
                for (int nb3 = nb2 + 1; nb3 < nums.length; nb3++) {
                    int sum = nums[nb1] + nums[nb2] + nums[nb3];
                    if (diff > Math.abs(target - sum)) {
                        diff = Math.abs(target - sum);
                        res = sum;
                    }
                }
            }
        }
        return res;
    }

    // Approach 2: Two pointer
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int diff = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        for (int mid = 0; mid < nums.length; mid++) {
            int low = mid+1;
            int high = nums.length-1;
            while (low < high) {
                int sum = nums[low] + nums[mid] + nums[high];
                if (diff > Math.abs(target-sum)){
                    diff = Math.abs(target-sum);
                    res = sum;
                }
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return res;
    }

    // Approach 3: Binary Search
    // Time Complexity: O(N^3)
    // Space Complexity: O(1)
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            for (int j = i + 1; j < sz - 1; ++j) {
                int complement = target - nums[i] - nums[j];
                var idx = Arrays.binarySearch(nums, j + 1, sz - 1, complement);
                int hi = idx >= 0 ? idx : ~idx, lo = hi - 1;
                if (hi < sz && Math.abs(complement - nums[hi]) < Math.abs(diff))
                    diff = complement - nums[hi];
                if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
                    diff = complement - nums[lo];
            }
        }
        return target - diff;
    }
}