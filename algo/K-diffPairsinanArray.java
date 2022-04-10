import java.util.HashSet;

class KdiffPairsinanArray {

    public int findPairs(int[] nums, int k) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (s1.contains(nums[i] - k)) {
                if (!s2.contains(Math.min(nums[i] - k, nums[i]) + ":" + Math.max(nums[i] - k, nums[i]))) {
                    res++;
                    s2.add(Math.min(nums[i] - k, nums[i]) + ":" + Math.max(nums[i] - k, nums[i]));
                }
            }
            if (s1.contains(nums[i] + k)) {
                if (!s2.contains(Math.min(nums[i] + k, nums[i]) + ":" + Math.max(nums[i] + k, nums[i]))) {
                    res++;
                    s2.add(Math.min(nums[i] + k, nums[i]) + ":" + Math.max(nums[i] + k, nums[i]));
                }
            }

            s1.add(nums[i]);
        }
        return res;
    }
}