import java.util.List;

class Combine {


    List<List<Integer>> res = new LinkedList();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return res;
    }
   
    // Backtracking
    // Time complexity : NCk = N!/(N−k)!k!
    // Space complexity : NCk
    public void backtrack(int nb, LinkedList<Integer> solution) {
        if (solution.size() == k) {
            res.addLast(new LinkedList(solution));
            return;
        } else {
            for (int i = nb; i<=n; i++) {
                solution.add(i);
                backtrack(i+1, solution);
                solution.removeLast();
            }
        }
    }

    //Lexicographic (binary sorted) combinations
    public List<List<Integer>> combine2(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i = 1; i < k + 1; ++i)
          nums.add(i);
        nums.add(n + 1);
    
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
          // add current combination
          output.add(new LinkedList(nums.subList(0, k)));
          // increase first nums[j] by one
          // if nums[j] + 1 != nums[j + 1]
          j = 0;
          while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
            nums.set(j, j++ + 1);
          nums.set(j, nums.get(j) + 1);
        }
        return output;
      }
}