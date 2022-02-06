import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
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
