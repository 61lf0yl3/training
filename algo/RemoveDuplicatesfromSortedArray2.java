class RemoveDuplicatesfromSortedArray2 {

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
}