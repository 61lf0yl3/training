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

    // Approach 2: Recursive Inorder Traversal
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    Integer prev = null;

    public boolean isValidBST2(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left))
            return false;
        if (prev != null && prev >= root.val)
            return false;
        prev = root.val;
        return dfs(root.right);
    }
}