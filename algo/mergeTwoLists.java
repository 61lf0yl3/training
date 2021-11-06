/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


class MergeTwoLists {
    // Time complexity : O(n+m)
    // Space complexity : O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode();
        ListNode temp = res;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        
        if (l1 != null) {
            temp.next = l1; 
        } else if (l2 != null) {
            temp.next = l2;
        }
        
        return res.next;   
    }

    // Recursion
    // Time complexity : O(n+m)
    // Space complexity : O(n+m)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}