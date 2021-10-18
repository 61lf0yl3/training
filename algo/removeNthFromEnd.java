class Solution {
    // Two pass algorithm
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode headCopy = head;
        int length = 0;
        while (headCopy != null) {
            length++;
            headCopy = headCopy.next;
        }
        length -= n;
        headCopy = dummy;
        while (length > 0) {
            length--;
            headCopy = headCopy.next;
        }
        System.out.println(head.val);
        headCopy.next = headCopy.next.next;
        return dummy.next;
    }

    // One pass algorithm
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

