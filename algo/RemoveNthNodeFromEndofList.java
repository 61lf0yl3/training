/**
 * Definition for singly-linked list.
 * struct ListNode {
 * int val;
 * ListNode *next;
 * ListNode() : val(0), next(nullptr) {}
 * ListNode(int x) : val(x), next(nullptr) {}
 * ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int m = 0;
        ListNode *res = new ListNode(0);
        res->next = head;
        ListNode* p = head;
        while (p != NULL) {
            p = p->next;
            m++;
        }
        p = res; 
        while (m-n > 0) {
            p = p->next;
            m--;
        }
        if (p->next != NULL) {
            p->next = p->next->next;
        } else {
            p->next = NULL;
        }
        return res->next;
    }
}
;