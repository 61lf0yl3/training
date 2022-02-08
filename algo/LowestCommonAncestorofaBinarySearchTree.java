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

class LowestCommonAncestorofaBinarySearchTree {
    // Approach 1: Iterative Approach
    // Time Complexity: O(H+k) where H is tree height;
    // Space Complexity: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (p.val < node.val && q.val < node.val) {
                if (node.left != null) {
                    queue.add(node.left);
                }
            } else if (p.val > node.val && q.val > node.val) {
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                return node;
            }
        }
        return null;
    }

    // Approach 1: Recursive Approach
    // Time Complexity: O(H+k) where H is tree height;
    // Space Complexity: O(h)
    public TreeNode lowestCommonAncestor2(TreeNode node, TreeNode p, TreeNode q) {
        if (p.val < node.val && q.val < node.val) {
            return lowestCommonAncestor(node.left, p, q);
        } else if (p.val > node.val && q.val > node.val) {
            return lowestCommonAncestor(node.right, p, q);
        } else {
            return node;
        }
    }
}