import java.util.ArrayList;
import java.util.Stack;
// 173. Binary Search Tree Iterator

// Approach 1: Using ArrayList
// Time Complexity: O(N)
// Space Complexity: O(N)
public class BinarySearchTreeIterator {
    public static void main(String[] args) {

    }
}

class BSTIterator {
    ArrayList<Integer> list;
    int pointer;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        DFS(root);
        pointer = 0;
    }

    public int next() {
        return list.get(pointer++);
    }

    public boolean hasNext() {
        if (pointer < list.size()) {
            return true;
        }
        return false;
    }

    private void DFS(TreeNode root) {
        if (root != null) {
            DFS(root.left);
            list.add(root.val);
            DFS(root.right);
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator2 {

    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {

        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}