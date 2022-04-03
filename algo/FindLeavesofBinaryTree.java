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
        int leftHight = getHeight(node.left);
        int rightHight = getHeight(node.right);

        int currHight = Math.max(leftHight, rightHight) + 1;

        if (res.size() <= currHight) {
            res.add(new ArrayList<>());
        }
        res.get(currHight).add(node.val);
        return currHight;
    }
}