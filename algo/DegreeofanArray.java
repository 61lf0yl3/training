import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DegreeofanArray {
    // Approach 1: Using HashMap
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        int max = 0;
        ArrayList<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) {
                m.put(nums[i], new ArrayList<>());
            }
            m.get(nums[i]).add(i);
            if (m.get(nums[i]).size() > max) {
                maxList = new ArrayList<>();
                maxList.add(nums[i]);
                max = m.get(nums[i]).size();
            } else if (m.get(nums[i]).size() == max) {
                maxList.add(nums[i]);
            }
        }
        int res = nums.length;
        for (int num : maxList) {
            List<Integer> list = m.get(num);
            int size = list.size();
            res = Math.min(res, list.get(size - 1) - list.get(0) + 1);
        }
        return res;
    }

    // Approach #1: Left and Right Index [Accepted]
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null)
                left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
}