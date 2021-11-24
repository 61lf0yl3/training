import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //res.add(new ArrayList());
        for (int len = 0; len <= nums.length; len++) {
            backtrack(nums, res, new LinkedList<Integer>(), len, 0);
        }
        return res;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> comb, int len, int start) {
        if (len == comb.size()) {
            res.add(new ArrayList(comb));
        } else {
            for (int i = start; i<nums.length; i++ ) {
                comb.add(nums[i]);
                backtrack(nums, res, comb, len, i+1);
                comb.removeLast();
            }
        }
    }
}