import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
// 138. Copy List with Random Pointer

class CopyListwithRandomPointer {
    // HashMap which holds old nodes as keys and new nodes as its values.
    Map<Node, Node> seen = new HashMap<>();

    // Approach 1: Recursive
    // Time complexity : O(N)
    // Space complexity : O(N)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // If we have already processed the current node, then we simply return the
        // cloned version of it.
        if (seen.containsKey(head)) {
            return seen.get(head);
        }

        // Create a new node with the value same as old node. (i.e. copy the node)
        Node newNode = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be loops
        // during traversal due to randomness of random pointers and this would help us
        // avoid them.
        seen.put(head, newNode);

        // Recursively copy the remaining linked list starting once from the next
        // pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }

    // Approach 1: Iterative
    // Time complexity : O(N)
    // Space complexity : O(N)
    Map<Node, Node> m = new HashMap<>();

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node clone = head;
        Node res = new Node(head.val);
        m.put(clone, res);
        while (clone != null) {
            res.next = getClone(clone.next);
            res.random = getClone(clone.random);

            res = res.next;
            clone = clone.next;
        }
        return m.get(head);
    }

    private Node getClone(Node node) {
        if (node == null) {
            return null;
        }
        if (!m.containsKey(node)) {
            m.put(node, new Node(node.val));
        }
        return m.get(node);
    }
}