import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

class AllPathsFromSourcetoTarget {
    //797. All Paths From Source to Target

    //Approach #1: Backtracking
    //Time Complexity: O(2^N*N)
    //Space Complexity: O(2^N*N)
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(graph, res, new LinkedList<Integer>(), 0);
        return res;
    }
    
    public void backtrack(int[][] graph, List<List<Integer>> res,  LinkedList<Integer> comb, int row) {
        if (row == graph.length-1) {
            comb.add(row);
            res.add(new ArrayList(comb));
            comb.removeLast();
        } else {
            for (int col = 0; col < graph[row].length; col++) {
                comb.add(row);
                backtrack(graph, res, comb, graph[row][col]);
                comb.removeLast();
            }
        }
    }
}
