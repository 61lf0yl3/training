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
    // Approach 2: Using HashSet
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

    /// Approach 2: Floyd's Cycle Finding Algorithm
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}