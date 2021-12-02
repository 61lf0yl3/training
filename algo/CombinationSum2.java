import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

class CombinationSum2 {

    //Approach 1: Backtracking
    //Time Complexity: O(2^N)
    //Space Complexity: O(N)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, res, new LinkedList<Integer>(), 0, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> comb, int sum, int start) {
        if (sum>=target) {
            if (sum==target) {
                res.add(new ArrayList(comb));
            }
        } else {
            for (int i=start; i<candidates.length; i++) {
                if (i !=start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                comb.add(candidates[i]);
                backtrack(candidates, target, res, comb, sum+candidates[i], i+1);
                comb.removeLast();
            }
        }
    }
}