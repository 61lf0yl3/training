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
}