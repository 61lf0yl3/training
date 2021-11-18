class RemoveDuplicatesfromSortedList {

    //Approach 1: Straight-Forward Approach
    //Time Complexity:O(N)
    //Space Complexity: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode copy = new  ListNode(0, head);
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;   
            }
        }
        return copy.next;
    }
}