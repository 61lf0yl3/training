/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int res;
    public int goodNodes(TreeNode root) {
        res = 0;
        dfs(root, root.val);
        return res;
    }
    

    private void dfs(TreeNode root, int currentMax) {
        if (root == null) {
            return;
        }
        if (root.val >= currentMax) {
            res++;
        }
        dfs(root.left, Math.max(currentMax, root.val));
        dfs(root.right, Math.max(currentMax, root.val));
    }
}