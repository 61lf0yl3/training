import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

public class InvertBinaryTree {
    // Approach 1: DFS
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }

    // Approach 1: BFS with Queue
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return root;
    }

    // Approach 1: Recursive
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree3(root.right);
        TreeNode left = invertTree3(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
