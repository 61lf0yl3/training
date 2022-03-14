class FirstMissingPositive {

    // Approach 1: Index as a hash key.
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int firstMissingPositive(int[] nums) {
        // Base case.
        int contains = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < nums.length; i++) {
            // nums[Math.abs(nums[i])] = -Math.abs(nums[Math.abs(nums[i])]);
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == nums.length) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return nums.length;
        }
        return nums.length + 1;
    }
}