import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class AllNodesDistanceKinBinaryTree {
    // 863. All Nodes Distance K in Binary Tree
ы
    // Approach 1: Annotate Parent
    // Time complexity : O(logN)
    // Space complexity : O(1)
    Map<TreeNode,TreeNode>m;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        m = new HashMap<>();
        Map<TreeNode, TreeNode> temp = m;
        dfs(root, null);

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(target, 0));

        List<Integer> res = new ArrayList<>();

        Set<TreeNode> seen = new HashSet<>();

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();

            if (seen.contains(p.getKey())) {
                continue;
            }
            seen.add(p.getKey());

            if (p.getKey() != null) {
                if (p.getValue() == k) {
                    res.add(p.getKey().val);
                }

                if (p.getKey().left != null) {
                    q.add(new Pair(p.getKey().left, p.getValue() + 1));
                }
                if (p.getKey().right != null) {
                    q.add(new Pair(p.getKey().right, p.getValue() + 1));
                }
                if (m.containsKey(p.getKey())) {
                    q.add(new Pair(m.get(p.getKey()), p.getValue() + 1));
                }
            }
        }
        return res;
    }

    public void dfs(TreeNode child, TreeNode parent) {
        if (child == null) {
            return;
        }
        m.put(child, parent);
        dfs(child.left, child);
        dfs(child.right, child);
    }
}