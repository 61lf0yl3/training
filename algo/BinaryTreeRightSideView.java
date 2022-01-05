import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
class BinaryTreeRightSideView {
    // 199. Binary Tree Right Side View

    // Approach 1: REcursive DFS
    // Time Complexity: O(N)
    // Space Complexity: O(H) to keep the recursion stack, where H is a tree height
    List<Integer> res;
    Set<Integer> seen;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        seen = new HashSet<>();
        rightSideViewR(root, 1);
        return res;
    }

    private void rightSideViewR(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (!seen.contains(depth)) {
            res.add(root.val);
            seen.add(depth);
        }
        rightSideViewR(root.right, depth + 1);
        rightSideViewR(root.left, depth + 1);
    }

    // Approach 1: BFS: Two Queues
    // Time Complexity: O(N)
    // Space Complexity: O(D) , where D is a tree diameter.
    public List<Integer> rightSideView2(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>() {
            {
                offer(root);
            }
        };
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        List<Integer> rightside = new ArrayList<>();

        TreeNode node = null;
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel.clone();
            nextLevel.clear();

            while (!currLevel.isEmpty()) {
                node = currLevel.poll();

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null)
                    nextLevel.offer(node.left);
                if (node.right != null)
                    nextLevel.offer(node.right);
            }

            // The current level is finished.
            // Its last element is the rightmost one.
            if (currLevel.isEmpty())
                rightside.add(node.val);
        }
        return rightside;
    }

    // Approach 3: BFS: One Queue + Sentinel
    // Time Complexity: O(N)
    // Space Complexity: O(D) , where D is a tree diameter.
    public List<Integer> rightSideView3(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        Queue<TreeNode> queue = new ArrayDeque<>() {
            {
                offer(root);
                offer(null);
            }
        };
        TreeNode prev, curr = root;
        List<Integer> rightside = new ArrayList<>();

        while (!queue.isEmpty()) {
            prev = curr;
            curr = queue.poll();

            while (curr != null) {
                // add child nodes in the queue
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                prev = curr;
                curr = queue.poll();
            }

            // the current level is finished
            // and prev is its rightmost element
            rightside.add(prev.val);
            // add a sentinel to mark the end
            // of the next level
            if (!queue.isEmpty())
                queue.offer(null);
        }
        return rightside;
    }
}