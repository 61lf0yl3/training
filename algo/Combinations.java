import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Combinations {
    // 77. Combinations

    // Approach 1: Backtracking
    // Time Complexity: O(Combination of K and N)
    // Space Complexity: O(Combination of K and N)
    List<List<Integer>> res;s
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtrak(1, new LinkedList<>());
        return res;
    }

    private void backtrak(int first, LinkedList<Integer> comb) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        } else {
            for (int i = first; i <= n; i++) {
                comb.add(i);
                backtrak(i + 1, comb);
                comb.removeLast();
            }
        }
    }
}