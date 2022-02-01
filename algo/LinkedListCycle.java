import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkedListCycle {
    /// Approach 2: Using HashSet
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!s.contains(p)) {
                s.add(p);
                p = p.next;
            } else {
                return true;
            }
        }
        return false;
    }
}