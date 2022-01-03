import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinaryTreeVerticalOrderTraversal {

    // Approach 1: BFS Optimised
    // Time complexity : O(N)
    // Space complexity : O(N)
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        bfs(root);

        for (int i = minCol; i <= maxCol; i++) {
            res.add(m.get(i));
        }
        return res;
    }

    // Approach 1: BFS
    // Time complexity : O(NlogN)
    // Space complexity : O(N)
    Map<Integer, ArrayList<Integer>> m = new HashMap<>();

    public List<List<Integer>> verticalOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        bfs(root);
        List<Integer> sortedKeys = new ArrayList<Integer>(m.keySet());
        Collections.sort(sortedKeys);
        for (int i : sortedKeys) {
            res.add(m.get(i));
        }
        return res;
    }

    public void bfs(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            int column = p.getValue();

            if (!m.containsKey(column)) {
                m.put(column, new ArrayList<>());
            }
            m.get(column).add(node.val);

            if (node.left != null) {
                q.add(new Pair(node.left, column - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, column + 1));
            }
        }
    }
}