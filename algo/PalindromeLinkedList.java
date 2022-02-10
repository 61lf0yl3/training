import java.util.ArrayList;

public class PalindromeLinkedList {
    // Approach 1: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> l = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            l.add(p.val);
            p = p.next;
        }
        p = head;
        for (int i = l.size() - 1; i >= l.size() / 2; i--) {
            if (l.get(i) != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
