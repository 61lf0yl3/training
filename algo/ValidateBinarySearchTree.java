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
class ValidateBinarySearchTree {
    // Approach 1: Recursive Traversal with Valid Range
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    boolean min = true;
    boolean max = true;

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode root, Integer start, Integer end) {
        if (root == null) {
            return true;
        }
        if ((start != null && start >= root.val) ||
                (end != null && end <= root.val)) {
            return false;
        }
        return dfs(root.left, start, root.val) && dfs(root.right, root.val, end);
    }

}