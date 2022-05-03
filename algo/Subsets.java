import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class Subsets {
    // 78. Subsets

    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        for (int i = 0; i <= nums.length; i++) {
            backtrack(new LinkedList<>(), 0, i);
        }
        return res;
    }

    // Appraoch #1: Backtraking
    // Time Complexity: O(N*N^2)
    // Space Complexity: O(N*N^2)
    private void backtrack(LinkedList<Integer> comb, int start, int len) {
        if (start == len) {
            res.add(new ArrayList<>(comb));
        } else {
            for (int j = start; j < nums.length; j++) {
                comb.add(nums[j]);
                backtrack(comb, j + 1, len);
                comb.removeLast();
            }
        }
    }

    // Appraoch #1: Cascading
    // Time Complexity: O(N*N^2)
    // Space Complexity: O(N*N^2)
    public List<List<Integer>> cascading(int[] nums, List<List<Integer>> res) {
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new LinkedList(res.get(i));
                temp.add(num);
                res.add(new ArrayList(temp));
            }
        }
        return res;
    }

    // Appraoch #1: Lexicographic (Binary Sorted) Subsets
    // Time Complexity: O(N*N^2)
    // Space Complexity: O(N*N^2)
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1')
                    curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}