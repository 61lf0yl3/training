import java.util.HashSet;

class KdiffPairsinanArray {

    // 532. K-diff Pairs in an Array

    // Approach 1: HashSet
    // Time complexity : O(N)
    // Space complexity : O(N)
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

    // Approach 1: Hashmap
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int findPairs2(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int key : m.keySet()) {
            if (k > 0 && m.containsKey(key + k)) {
                res++;
            } else if (k == 0 && m.get(key) > 1) {
                res++;
            }
        }
        return res;
    }
}