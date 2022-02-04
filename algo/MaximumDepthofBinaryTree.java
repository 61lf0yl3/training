import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

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

class MaximumDepthofBinaryTree {
    // Approach 1: BFS
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // Approach 2: DFS
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int maxDepth = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}