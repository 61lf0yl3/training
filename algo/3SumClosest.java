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

    // Approach 2: Brute Force
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
}