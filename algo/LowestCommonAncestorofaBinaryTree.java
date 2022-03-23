import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorofaBinaryTree {
    // Approach 1: Recursive Approach
    // Time Complexity: O(N) where N is the number of nodes
    // Space Complexity: O(N) recursion stack would be N
    TreeNode p;
    TreeNode q;
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        lowestCommonAncestorR(root);
        return res;
    }

    private boolean lowestCommonAncestorR(TreeNode root) {
        if (root == null) {
            return false;
        }
        int left = 0;
        if (lowestCommonAncestorR(root.left)) {
            left = 1;
        }
        int right = 0;
        if (lowestCommonAncestorR(root.right)) {
            right = 1;
        }
        int mid = 0;
        if (root.val == p.val || root.val == q.val) {
            mid = 1;
        }
        if (left + right + mid >= 2) {
            res = root;
        }
        return left + right + mid > 0;
    }

    // Approach 2: Iterative using parent pointers
    // Time Complexity: O(N) where N is the number of nodes
    // Space Complexity: O(N) recursion stack would be N
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                parents.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                queue.add(node.right);
            }
        }

        Set<TreeNode> path = new HashSet<>();

        while (p != null) {
            path.add(p);
            p = parents.get(p);
        }

        while (!path.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}