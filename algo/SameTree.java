import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {
    // Approach 1: BFS with Queue
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) {
            return true;
        }
        if (!check(p, q)) {
            return false;
        }

        Queue<TreeNode> q1 = new ArrayDeque<>();
        q1.add(p);
        Queue<TreeNode> q2 = new ArrayDeque<>();
        q2.add(q);

        while (!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (p != null) {
                if (!check(node1, node2)) {
                    return false;
                }
                if (!check(node1.left, node2.left)) {
                    return false;
                }
                if (node1.left != null) {
                    q1.add(node1.left);
                    q2.add(node2.left);

                }
                if (!check(node1.right, node2.right)) {
                    return false;
                }
                if (node1.right != null) {
                    q1.add(node1.right);
                    q2.add(node2.right);
                }
            }
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) {
            return true;
        }
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }
}
