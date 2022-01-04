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
    // Approach 1: Annotate Parent
    // Time complexity : O(logN)
    // Space complexity : O(1)
    Map<TreeNode, TreeNode> m;

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

class AllNodesDistanceKinBinaryTree2 {
    List<Integer> ans;
    TreeNode target;
    int K;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left), R = dfs(node.right);
            if (L != -1) {
                if (L == K)
                    ans.add(node.val);
                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K)
                    ans.add(node.val);
                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null)
            return;
        if (dist == K)
            ans.add(node.val);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}