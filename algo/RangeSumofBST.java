import java.util.Stack;

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
class RangeSumofBST {
    // Approach 1: Recursive Approach
    // Time Complexity: O(N) where N is the number of nodes
    // Space Complexity: O(N) recursion stack would be N
    int res = 0;
    int low;
    int high;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        rangeSumBSTR(root);
        return res;
    }

    private void rangeSumBSTR(TreeNode root) {
        if (root == null) {
            return;
        }
        if (low <= root.val && root.val <= high) {
            res += root.val;
        }
        rangeSumBSTR(root.left);
        rangeSumBSTR(root.right);
    }

    private void rangeSumBSTR2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (low <= root.val && root.val <= high) {
            res += root.val;
        }
        if (low < root.val) {
            rangeSumBSTR(root.left);
        }
        if (high > root.val) {
            rangeSumBSTR(root.right);
        }
    }

    // Approach 1: Iterative Approach
    // Time Complexity: O(N) where N is the number of nodes
    // Space Complexity: O(N) recursion stack would be N
    public int rangeSumBST3(TreeNode root, int low, int high) {
        int res = 0;
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high) {
                    res += node.val;
                }
                if (low < node.val) {
                    s.add(node.left);
                }
                if (node.val < high) {
                    s.add(node.right);
                }
            }
        }
        return res;
    }
}