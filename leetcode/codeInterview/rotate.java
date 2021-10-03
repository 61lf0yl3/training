class Solution4 {
    public void rotate(int[] nums, int k) {
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
}