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
class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode headForlength = head;
        while (headForlength != null) {
            length++;
            headForlength = headForlength.next;
        }
        
        int middle = length/2;
        int counter = 0;
        while (head != null) {
            if (counter == middle) {
                break;
            }
            counter++;
            head = head.next;
        }
        
    return head;
    }
}