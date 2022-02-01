import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergekSortedLists {
    // Approach 3: Optimize Approach 2 by Priority Queue
    // Time Complexity: O(NlogK)
    // Space Complexity: O(N)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (ListNode head : lists) {
            while (head != null) {
                q.add(head.val);
                head = head.next;
            }
        }

        ListNode p = new ListNode(0);
        ListNode res = p;
        while (!q.isEmpty()) {
            p.next = new ListNode(q.poll());
            p = p.next;
        }

        return res.next;
    }
}