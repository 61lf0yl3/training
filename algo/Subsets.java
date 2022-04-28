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
            backtrack(i, 0, new LinkedList<>());
        }

        return res;

    }

    // Appraoch #1: Backtraking
    // Time Complexity: O(N*N^2)
    // Space Complexity: O(N*N^2)
    private void backtrack(int size, int start, LinkedList<Integer> comb) {
        if (comb.size() == size) {
            res.add(new LinkedList<>(comb));
        } else {
            for (int i = start; i < nums.length; i++) {
                comb.add(nums[i]);
                backtrack(size, i + 1, comb);
                comb.removeLast();
            }
        }
    }

    // Appraoch #1: Cascading
    // Time Complexity: O(N*N^2)
    // Space Complexity: O(N*N^2)
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> temp = new ArrayList<>(res.get(i));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }

    // Appraoch #1: Lexicographic (Binary Sorted) Subsets
    // Time Complexity: O(N*N^2)
    // Space Complexity: O(N*N^2)
    public List<List<Integer>> subsets3(int[] nums) {
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