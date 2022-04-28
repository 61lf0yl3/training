class RemoveDuplicatesfromSortedArray2 {

    // Approach 1: Overwriting unwanted duplicates
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int count = 0;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                count++;
                if (count <= 2) {
                    nums[pointer++] = curr;
                }
            } else {
                curr = nums[i];
                count = 1;
                nums[pointer++] = curr;
            }
        }
        return pointer;
    }

    // Approach 1: Overwriting unwanted duplicates
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int removeDuplicates2(int[] nums) {

        // Initialize the counter and the second pointer.
        int j = 1, count = 1;

        // Start from the second element of the array and process
        // elements one by one.
        for (int i = 1; i < nums.length; i++) {
            // If the current element is a duplicate, increment the count.
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // Reset the count since we encountered a different element
                // than the previous one.
                count = 1;
            }

            // For a count <= 2, we copy the element over thus
            // overwriting the element at index "j" in the array
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}