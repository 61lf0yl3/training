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
    // Approach 1: Priority Queue
    // Time Complexity: O(NlogN*K)
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

    // Approach 2: Divide And Conquer
    // Time Complexity: O(NlogK)
    // Space Complexity: O(1)
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            System.out.println(lists.length);
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
    }

    // Approach 2: Optimize Approach 2 by Priority Queue
    // Time Complexity: O(NlogK)
    // Space Complexity: O(K)
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = new ListNode(-1);
        ListNode p = res;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;

            // you don't need to set curr.next as null since the last node is always be one
            // of the last node of each list. Its next must be null.
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return res.next;
    }
}