import java.util.ArrayDeque;
import java.util.Queue;

class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);

        return res.deleteCharAt(res.length() - 1).toString();
    }

    private void serialize(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("N").append(',');
            return;
        }
        res.append(root.val).append(',');
        serialize(root.left, res);
        serialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for (String val : nodeValues) {
            queue.add(val);
        }

        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty())
            return null;
        String value = queue.remove();

        if (value.equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserialize(queue);
        root.right = deserialize(queue);

        return root;
    }
}
