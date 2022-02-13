public class DiameterofBinaryTree {
    // Approach 1: Depth-first Search
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        DFS(root);
        return res;
    }

    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
