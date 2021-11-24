import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int len = 0; len <= nums.length; len++) {
            backtrack(nums, res, new LinkedList<Integer>(), len, 0);
        }
        return res;
    }
    
    //Appraoch #1: Backtraking
    //Time Complexity: O(N*N^2)
    //Space Complexity: O(N)
    public void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> comb, int len, int start) {
        if (comb.size() == len) {
                res.add(new ArrayList<>(comb));
                return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[i - 1]) {
                continue;
                }
                    comb.add(nums[i]);
                    backtrack(nums, res, comb, len, i+1);
                    comb.removeLast();
            }
        }
    }
}