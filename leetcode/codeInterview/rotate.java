class Solution4 {
    public void rotate2(int[] nums, int k) {
        int[]  res = new int[nums.length];
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            res[(i+k)%nums.length] = nums[i];
        }
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
      }
      public void reverse(int[] nums, int start, int end) {
        while (start < end) {
          int temp = nums[start];
          nums[start] = nums[end];
          nums[end] = temp;
          start++;
          end--;
        }
      }
}