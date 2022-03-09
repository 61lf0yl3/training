import java.util.ArrayList;

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
        if (root == null) {
            return;
        } else {
            DFS(root.left);
            list.add(root.val);
            DFS(root.right);
        }
    }
}
