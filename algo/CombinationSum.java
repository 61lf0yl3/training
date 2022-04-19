import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class CombinationSum {
    // Approach 1: Backtracking
    // Time Complexity: O(N^(T/M+1))
    // Space Complexity: O(N^T/M)
    int[] candidates;
    int target;
    List<List<Integer>> res;
    LinkedList<Integer> comb;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        res = new ArrayList<>();
        comb = new LinkedList<>();
        dp(0, 0);
        return res;
    }

    private void dp(int sum, int i) {
        List<List<Integer>> res1 = res;
        LinkedList<Integer> comb1 = comb;
        if (sum > target) {
            return;
        } else if (sum == target) {
            res.add(new LinkedList<>(comb));
        } else {
            for (int j = i; j < candidates.length; j++) {
                comb.add(candidates[j]);
                dp(sum + candidates[j], j);
                comb.removeLast();
            }
        }
    }
}