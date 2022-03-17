import java.util.ArrayList;
import java.util.List;

class FindLeavesofBinaryTree {
    // Approach 1: DFS
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    List<List<Integer>> res;

    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>();
        getHeight(root);
        return res;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        if (res.size() == currHeight) {
            res.add(new ArrayList<>());
        }
        res.get(currHeight).add(node.val);

        return currHeight;
    }
}