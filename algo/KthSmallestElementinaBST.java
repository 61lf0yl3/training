import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class KthSmallestElementinaBST {
    // Approach 1: Recursive Inorder Traversal
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    ArrayList<Integer> al = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return al.get(k - 1);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        al.add(root.val);
        dfs(root.right);
    }

    // Approach 1: Iterative Inorder Traversal
    // Time Complexity: O(H+k) where H is tree height;
    // Space Complexity: O(h)
    public int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
    }

    // Approach 1: Iterative Inorder Traversal with Queue;
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int kthSmallest3(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            pq.add(node.val);
            if (pq.size() > k) {
                pq.remove();
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return pq.peek();
    }
}
