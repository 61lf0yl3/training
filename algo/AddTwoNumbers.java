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
class AddTwoNumbers {
    // 2. Add Two Numbers

    // Approach 1: Elementary Math
    // Time Complexity: O(max(m,n))
    // Space Complexity: O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int remain = 0;
        while (l1 != null || l2 != null) {
            int x = 0;
            int y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int sum = remain + x + y;
            remain = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (remain > 0) {
            curr.next = new ListNode(remain);
        }
        return res.next;
    }
}