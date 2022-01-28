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
        lowestCommonAncestor(root);
        return res;
    }

    private boolean lowestCommonAncestor(TreeNode root) {
        if (root == null) {
            return false;
        }
        int left = 0;
        if (lowestCommonAncestor(root.left)) {
            left = 1;
        }
        int right = 0;
        if (lowestCommonAncestor(root.right)) {
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
}